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


    public static final Rotation2d restingrot = new Rotation2d();
    public static final Rotation2d intakerot = new Rotation2d();
    public static final Rotation2d L1rot = new Rotation2d();
    public static final Rotation2d L2rot = new Rotation2d();
    public static final Rotation2d L3rot = new Rotation2d();
    public static final Rotation2d L4rot = new Rotation2d();
  }

  public static class ElevatorConstants {
    public static final int leadMotorID = 30;
    public static final int followerMotorID = 31;
    public static final int bottomlimitswitchID = 1;
    public static final int toplimitswitchID = 1;

    public static final Rotation2d restingheight = new Rotation2d();
    public static final Rotation2d intakeheight = new Rotation2d().fromRotations(-40);
    public static final Rotation2d L1height = new Rotation2d();
    public static final Rotation2d L2height = new Rotation2d();
    public static final Rotation2d L3height = new Rotation2d();
    public static final Rotation2d L4height = new Rotation2d();
  }
}
