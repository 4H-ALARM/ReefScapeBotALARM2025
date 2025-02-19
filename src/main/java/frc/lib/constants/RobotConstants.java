package frc.lib.constants;

import edu.wpi.first.math.geometry.Rotation2d;

public class RobotConstants {

  public static class IntakeConstants {
    public static final int tiltMotorID = 1;
    public static final int spinMotorID = 2;

    public static final Rotation2d inactiveAngle = Rotation2d.fromDegrees(0);
    public static final Rotation2d activeAngle = Rotation2d.fromDegrees(0);
    public static final Rotation2d holdAngle = Rotation2d.fromDegrees(0);
  }

  public static class EndEffectorConstants {

    public static int wristmotorID = 19;
    public static int clawmotorID = 20;

    public static final Rotation2d restingrot = Rotation2d.fromRotations(19);
    public static final Rotation2d intakerot = Rotation2d.fromRotations(18.7);
    public static final Rotation2d L1rot = Rotation2d.fromRotations(4);
    public static final Rotation2d L2rot = Rotation2d.fromRotations(3);
    public static final Rotation2d L3rot = Rotation2d.fromRotations(2);
    public static final Rotation2d L4rot = Rotation2d.fromRotations(0);

    public static final double intakespeed = 0.5;
    public static final double holdspeed = 0.1;
    public static final double throwspeed = -0.3;
  }

  public static class ElevatorConstants {
    public static final int leadMotorID = 30;
    public static final int followerMotorID = 31;
    public static final int bottomlimitswitchID = 1;
    public static final int toplimitswitchID = 1;

    public static final Rotation2d restingheight = Rotation2d.fromRotations(0);
    public static final Rotation2d intakeheight = Rotation2d.fromRotations(-4.6);
    public static final Rotation2d L1height = Rotation2d.fromRotations(0);
    public static final Rotation2d L2height = Rotation2d.fromRotations(-15);
    public static final Rotation2d L3height = Rotation2d.fromRotations(-37.5);
    public static final Rotation2d L4height = Rotation2d.fromRotations(-69.25);
  }
}
