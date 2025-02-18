package frc.robot.subsystems.claw;

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

import org.littletonrobotics.junction.Logger;

public class WristIONeo implements WristIO {
  private final SparkMax motor;
  private final SparkClosedLoopController pidController;
  private final RelativeEncoder encoder;

  // Desired angle for the wrist
  private double desiredAngle = 0.0;

  // Constructor
  public WristIONeo() {

    motor = new SparkMax(RobotConstants.EndEffectorConstants.wristmotorID, MotorType.kBrushless);
    encoder = motor.getEncoder();
    encoder.setPosition(0);
    pidController = motor.getClosedLoopController();

    SparkMaxConfig config = new SparkMaxConfig();
    config
        .closedLoop
        .pid(0.5, 0, 0)
        .minOutput(-0.3)
        .maxOutput(0.3)
        .feedbackSensor(FeedbackSensor.kPrimaryEncoder)
        .maxMotion
        .allowedClosedLoopError(0.3)
        .maxAcceleration(30000)
        .maxVelocity(5600);

    motor.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
  }

  @Override
  public void setAngle(Rotation2d angle) {
    pidController.setReference(angle.getRotations(), ControlType.kMAXMotionPositionControl);
  }

  public Rotation2d getAngle() {

    return Rotation2d.fromRotations(
        encoder.getPosition()); // Adjust based on your encoder configuration
  }

  @Override
  public void stopMotor() {
    motor.stopMotor();
  }

  @Override
  public void resetEncoder() {
    encoder.setPosition(0);
  }

  @Override
  public void log() {
    Logger.recordOutput("Wrist/angle", encoder.getPosition());
  }

  public void updateInputs(WristIOInputs inputs) {
    inputs.angle = getAngle().getDegrees();
    Logger.recordOutput("Wrist/angle", encoder.getPosition());
  }
}
