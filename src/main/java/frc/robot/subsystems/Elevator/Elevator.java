// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Elevator;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.lib.statehandler.stateHandler;

public class Elevator extends SubsystemBase {
  /** Creates a new Elevator. */
  private final ElevatorIO elevator;

  private ElevatorIOInputsAutoLogged elevatorinputs;

  private stateHandler stateHandler;

  public Elevator(ElevatorIO elevator, stateHandler handler) {
    this.elevator = elevator;
    stateHandler = handler;
    elevatorinputs = new ElevatorIOInputsAutoLogged();
  }

  public void moveElevator(double input) {
    this.elevator.move(input);
  }

  public void stopElevator() {
    elevator.stopElevator();
  }

  public ElevatorIO getElevatorInstance() {
    return this.elevator;
  }

  public void resetEncoder() {
    this.elevator.resetEncoder();
  }

  public boolean getResults() {
    return elevator.getResults();
  }

  @Override
  public void periodic() {
    elevator.moveToState(stateHandler.getState());
    elevator.updateInputs(elevatorinputs);
  }
}
