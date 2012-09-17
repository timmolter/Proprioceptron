package com.xeiam.proprioceptron.states;

import com.xeiam.proprioceptron.FreeVar;
import com.xeiam.proprioceptron.State;

class LengthState implements State {

  FreeVar[] lengths;

  @Override
  public String[] vectorDoc() {

    return new String[] { "lengths * " + lengths.length };
  }

  @Override
  public FreeVar[] toVector() {

    return lengths;
  }

  @Override
  public void addVars(FreeVar[] vars) {

    lengths = vars;
  }

}