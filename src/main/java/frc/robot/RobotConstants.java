package frc.robot;

import edu.wpi.first.math.geometry.Rotation2d;

public class RobotConstants {

  public static class Intake {
    public static final int tiltMotorID = 1;
    public static final int spinMotorID = 2;

    public static final Rotation2d inactiveAngle = Rotation2d.fromDegrees(0);
    public static final Rotation2d activeAngle = Rotation2d.fromDegrees(0);
    public static final Rotation2d holdAngle = Rotation2d.fromDegrees(0);
  }

  public static class Elevator {
    public static final int leadMotorID = 1;
    public static final int followerMotorID = 2;
    public static final int bottomlimitswitchID = 1;
    public static final int toplimitswitchID = 1;

    public static final Rotation2d defaultheight = new Rotation2d();
    public static final Rotation2d intakeheight = new Rotation2d();
    public static final Rotation2d L1height = new Rotation2d();
    public static final Rotation2d L2height = new Rotation2d();
    public static final Rotation2d L3height = new Rotation2d();
    public static final Rotation2d L4height = new Rotation2d();

    public static enum elevatorState {
      DEFAULT(defaultheight),
      INTAKE(intakeheight),
      L1(L1height),
      L2(L2height),
      L3(L3height),
      L4(L4height);

      private final Rotation2d target;

      elevatorState(Rotation2d rotation2d) {
        this.target = rotation2d;
      }

      public Rotation2d getTargetRotation2d() {
        return target;
      }
    }
  }
}
