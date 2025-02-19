// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.lib.statehandler;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Elevator.Elevator;
import frc.robot.subsystems.claw.EndEffector;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class setStateIntake extends Command {
  /** Creates a new setStateIntake. */
  stateHandler handler;

  Elevator elevator;
  EndEffector endEffector;

  public setStateIntake(Elevator e, EndEffector ee, stateHandler sh) {
    this.handler = sh;
    this.elevator = e;
    this.endEffector = ee;
    addRequirements(elevator, endEffector);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    this.handler.setState(robotState.INTAKE);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    this.handler.setState(robotState.RESTING);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (elevator.getResults() && endEffector.getResults()) {
      return true;
    }
    return false;
  }
}
