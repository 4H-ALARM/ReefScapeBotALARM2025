// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Elevator;

import edu.wpi.first.math.geometry.Rotation2d;
import frc.lib.statehandler.robotState;
import org.littletonrobotics.junction.AutoLog;

/** Add your docs here. */
public interface ElevatorIO {
  @AutoLog
  public static class ElevatorIOInputs {
    // double axleRotation;
    // double motorRotation;
    // double motorDiff;
    // boolean leadisConnected;
    // boolean followerisConnected;
    // String enumState;
  }

  public void moveToState(robotState state);

  public void move(double input);

  public void stopElevator();

  public double getEncoder();

  public void resetEncoder();

  public void moveToPoint(Rotation2d targetRot);

  public boolean getResults();

  public default void updateInputs(ElevatorIOInputs inputs) {}
}
