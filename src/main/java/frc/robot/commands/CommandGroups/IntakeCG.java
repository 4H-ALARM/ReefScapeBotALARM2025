// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.CommandGroups;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.commands.ElevatorCommands.elevatorSetHeightIntake;
import frc.robot.commands.EndEffector.IntakeClaw;
import frc.robot.commands.EndEffector.IntakeWrist;
import frc.robot.subsystems.Elevator.Elevator;
import frc.robot.subsystems.claw.EndEffector;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class IntakeCG extends ParallelCommandGroup {
  /** Creates a new Intake. */
  public IntakeCG(Elevator elevator, EndEffector endEffector) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
        new elevatorSetHeightIntake(elevator),
        new IntakeWrist(endEffector),
        new IntakeClaw(endEffector));
  }
}
