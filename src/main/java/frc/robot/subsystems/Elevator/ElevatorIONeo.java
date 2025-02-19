package frc.robot.subsystems.Elevator;

import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkBase.ControlType;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkClosedLoopController;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.ClosedLoopConfig.FeedbackSensor;
import com.revrobotics.spark.config.SparkMaxConfig;
import edu.wpi.first.math.geometry.Rotation2d;
import frc.lib.constants.RobotConstants;
import frc.lib.statehandler.robotState;

public class ElevatorIONeo implements ElevatorIO {

  private final SparkMax leadMotor;
  private final SparkMax followerMotor;

  private final RelativeEncoder encoder;

  private final SparkClosedLoopController pid;

  private final SparkMaxConfig leadConfig;
  private final SparkMaxConfig followerConfig;

  private robotState targetState;

  // private final DigitalInput bottomLimitSwitch;
  // private final DigitalInput topLimitSwitch;

  public ElevatorIONeo() {

    // bottomLimitSwitch = new DigitalInput(RobotConstants.Elevator.bottomlimitswitchID);
    // topLimitSwitch = new DigitalInput(RobotConstants.Elevator.toplimitswitchID);

    leadMotor = new SparkMax(RobotConstants.ElevatorConstants.leadMotorID, MotorType.kBrushless);
    followerMotor =
        new SparkMax(RobotConstants.ElevatorConstants.followerMotorID, MotorType.kBrushless);

    encoder = leadMotor.getEncoder();
    encoder.setPosition(0);
    pid = leadMotor.getClosedLoopController();

    leadConfig = new SparkMaxConfig();

    leadConfig
        .closedLoop
        .pid(0.0025, 0, 0)
        .minOutput(-1)
        .maxOutput(1)
        .feedbackSensor(FeedbackSensor.kPrimaryEncoder);

    leadMotor.configure(leadConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

    followerConfig = new SparkMaxConfig();
    followerConfig.apply(leadConfig);
    followerConfig.follow(RobotConstants.ElevatorConstants.leadMotorID, true);
    followerMotor.configure(
        followerConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

    targetState = robotState.RESTING;
  }

  @Override
  public void moveToState(robotState state) {
    boolean atLowestPoint = false;
    boolean atHighestPoint = false;
    // if (bottomLimitSwitch.get()) {
    //   atLowestPoint = true;
    // }
    // if (topLimitSwitch.get()) {
    //   atHighestPoint = true;
    // }
    targetState = state;
    moveToPoint(state.getState().elevatorHeightRot);
  }

  @Override
  public void moveToPoint(Rotation2d targetRot) {
    // if (bottomLimitSwitch.get()
    //     && targetRot.getDegrees() < Rotation2d.fromRotations(encoder.getPosition()).getDegrees())
    // {
    //   stopElevator();
    // }
    // if (topLimitSwitch.get()
    //     && targetRot.getDegrees() > Rotation2d.fromRotations(encoder.getPosition()).getDegrees())
    // {
    //   stopElevator();
    // }
    pid.setReference(targetRot.getRotations(), ControlType.kMAXMotionPositionControl);
  }

  @Override
  public void move(double input) {
    double realinput = input * 0.2;

    if (realinput > 0.15) {
      realinput = 0.15;
    }

    if (realinput < -0.15) {
      realinput = -0.15;
    }

    leadMotor.set(realinput);
  }

  @Override
  public double getEncoder() {
    return encoder.getPosition();
  }

  @Override
  public void stopElevator() {
    leadMotor.stopMotor();
  }

  @Override
  public void resetEncoder() {
    encoder.setPosition(0);
  }

  @Override
  public boolean getResults() {
    if (encoder.getPosition() < targetState.getState().elevatorHeightRot.getRotations() + 0.3
        && encoder.getPosition() > targetState.getState().elevatorHeightRot.getRotations() - 0.3) {
      return true;
    }
    return false;
  }

  @Override
  public void updateInputs(ElevatorIOInputs inputs) {
    inputs.axleRotation = leadMotor.getAlternateEncoder().getPosition();
    inputs.motorRotation = leadMotor.getEncoder().getPosition();
    inputs.motorDiff =
        leadMotor.getEncoder().getPosition() >= 0
            ? leadMotor.getEncoder().getPosition() - followerMotor.getEncoder().getPosition()
            : leadMotor.getEncoder().getPosition() + followerMotor.getEncoder().getPosition();
    inputs.enumState = targetState.toString();
  }
}
