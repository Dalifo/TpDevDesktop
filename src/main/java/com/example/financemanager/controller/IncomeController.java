package com.example.financemanager.controller;

import com.example.financemanager.db.IncomeDAO;
import com.example.financemanager.model.Income;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Dialog;
import javafx.scene.control.TableView;
import org.slf4j.Logger;

import java.util.Optional;

public class IncomeController {
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(IncomeController.class);

    @FXML
    private TableView<Income> incomeTable;

    public void initialize() {
        incomeTable.setItems(IncomeDAO.getIncomes());
    }

    public void addIncome(ActionEvent event) {
        Dialog<Income> addPersonDialog = new IncomeDialog();
        Optional<Income> result = addPersonDialog.showAndWait();
        result.ifPresent(IncomeDAO::insertIncome);

        log.debug(result.toString());
        event.consume();
    }

}