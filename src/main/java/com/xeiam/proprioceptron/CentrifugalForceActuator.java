package com.xeiam.proprioceptron;

class CentrifugalForceActuator implements Actuator {

  PositionState positions;
  LengthState lengths;
  DensityState densities;
  AngularVelocityState angularvels;
  DirectionState directions;
  // codomain vars
  TensionState tensions;

  public void setDomain(PositionState positions, LengthState lengths, DensityState densities, AngularVelocityState angularvels, DirectionState directions) {

    this.positions = positions;
    this.lengths = lengths;
    this.densities = densities;
    this.angularvels = angularvels;
    this.directions = directions;

  }

  public void setRange(TensionState tensions) {

    this.tensions = tensions;
  }

  @Override
  public void actuate() {

    for (int i = 0; i < lengths.lengths.length; i++) {
      tensions.tensions[i].setDimensional(Vector.scale(angularvels.angularvelocities[i].getVar() * angularvels.angularvelocities[i].getVar() / lengths.lengths[i].getVar(),
          (Vector) directions.directions[i].getDimensional()));
    }
  }
}