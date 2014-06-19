package com.github.pedrovgs.effectiveandroidui.ui.viewmodel.action;

/**
 * Interface created to represent ActionCommands associated to MVVM implementation. View models
 * returns ActionCommands to perform some UI operations.
 *
 * In a MVVM classic implementation every action performed by the user should finish executing an
 * ActionCommand implementation.
 *
 * @author Pedro Vicente Gómez Sánchez
 */
public interface ActionCommand {
  void execute();
}
