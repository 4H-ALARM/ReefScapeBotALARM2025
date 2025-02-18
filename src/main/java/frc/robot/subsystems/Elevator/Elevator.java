// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Elevator;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.lib.config.ewstate;
import frc.lib.statehandler.statesEnum;

public class Elevator extends SubsystemBase {
  /** Creates a new Elevator. */
  private final ElevatorIO elevator;

  private ElevatorIOInputsAutoLogged elevatorinputs;

  private statesEnum state;

  public Elevator(ElevatorIO elevator) {
    this.elevator = elevator;
    elevatorinputs = new ElevatorIOInputsAutoLogged();
    this.state = statesEnum.RESTING;
  }

  public void moveElevator(double input) {
    this.elevator.move(input);
  }

  public void setGoalState(statesEnum givenstate) {
    elevator.moveToState(givenstate);
  }

  public statesEnum getGoalState() {
    return this.state;
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

  @Override
  public void periodic() {

    elevator.updateInputs(elevatorinputs);
  }
}
