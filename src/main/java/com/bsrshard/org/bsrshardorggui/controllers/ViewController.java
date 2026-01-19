package com.bsrshard.org.bsrshardorggui.controllers;

import com.bsrshard.org.bsrshardorggui.models.*;
import com.bsrshard.org.bsrshardorggui.views.View;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Objects;
import java.util.Stack;

public class ViewController {




    @FXML private TreeTableView<ShardRow> treeTableView;

    @FXML private TreeTableColumn<ShardRow, Integer> idColumn;
    @FXML private TreeTableColumn<ShardRow, Integer> hpColumn;
    @FXML private TreeTableColumn<ShardRow, Integer> defColumn;
    @FXML private TreeTableColumn<ShardRow, Integer> attackColumn;
    @FXML private TreeTableColumn<ShardRow, Double> critRateColumn;
    @FXML private TreeTableColumn<ShardRow, Double> critDmgColumn;
    @FXML private TreeTableColumn<ShardRow, Double> ailmentDmgColumn;
    @FXML private TreeTableColumn<ShardRow, Double> slashDmgColumn;
    @FXML private TreeTableColumn<ShardRow, Double> strikeDmgColumn;
    @FXML private TreeTableColumn<ShardRow, Double> thrustDmgColumn;
    @FXML private TreeTableColumn<ShardRow, Double> spiritDmgColumn;
    @FXML private TreeTableColumn<ShardRow, Double> ultimateCRateColumn;



    @FXML
    private ImageView imageView;
    StringProperty stats = new SimpleStringProperty();

    @FXML
    private ComboBox<String> dropdownMenu;



    // Basic Stats
    @FXML private Label hpLabel;
    @FXML private Label atkLabel;
    @FXML private Label defLabel;

    // Advanced Stats
    @FXML private Label critRateLabel;
    @FXML private Label critDmgLabel;
    @FXML private Label healingEffectLabel;
    @FXML private Label healedEffectLabel;
    @FXML private Label cooldownRedLabel;
    @FXML private Label dissipationDmgLabel;
    @FXML private Label ultimateChargeLabel;
    @FXML private Label basicAtkDmgLabel;
    @FXML private Label techniqueDmgLabel;

    @FXML private Label ultimateDmgLabel;
    @FXML private Label specialAtkDmgLabel;
    @FXML private Label battlefieldDmgLabel;
    @FXML private Label slashDmgLabel;
    @FXML private Label strikeDmgLabel;
    @FXML private Label thrustDmgLabel;
    @FXML private Label spiritDmgLabel;
    @FXML private Label ailmentDmgLabel;

    private void createChar(){
        BleachCharacter bichigo = new BleachCharacter("Bankai Ichigo", 10449, 2182, 1763,5.0,0.0,100.0,100.0,0.0,20.0,100.0,0.0,0.0,0.0,0.0,0.0,11.0,0.0,0.0,0.0,0.0);
        CharacterList.addCharacter(bichigo);
    }

    public void setCharacter(BleachCharacter bc) {

        // Basic Stats
        hpLabel.setText("HP: " + bc.getHp());
        atkLabel.setText("ATK: " + bc.getAtk());
        defLabel.setText("DEF: " + bc.getDef());

        // Advanced Stats
        critRateLabel.setText("Crit Rate: " + bc.getCritRate());
        critDmgLabel.setText("Crit Damage: " + bc.getCritDmg());
        healingEffectLabel.setText("Healing Effect: " + bc.getHealingEffect());
        healedEffectLabel.setText("Healed Effect: " + bc.getHealedEffect());
        cooldownRedLabel.setText("Cooldown Reduction: " + bc.getCooldownRed());
        dissipationDmgLabel.setText("Dissipation Damage: " + bc.getDissipationDmg());
        ultimateChargeLabel.setText("Ultimate Charge: " + bc.getUltimateCharge());
        basicAtkDmgLabel.setText("Basic Attack Damage: " + bc.getBasicAtkDmg());
        techniqueDmgLabel.setText("Technique Damage: " + bc.getTechniqueDmg());

        ultimateDmgLabel.setText("Ultimate Damage: " + bc.getUltimateDmg());
        specialAtkDmgLabel.setText("Special Attack Damage: " + bc.getSpecialAtkDmg());
        battlefieldDmgLabel.setText("Battlefield Damage: " + bc.getBattlefieldDmg());
        slashDmgLabel.setText("Slash Damage: " + bc.getSlashDmg());
        strikeDmgLabel.setText("Strike Damage: " + bc.getStrikeDmg());
        thrustDmgLabel.setText("Thrust Damage: " + bc.getThrustDmg());
        spiritDmgLabel.setText("Spirit Damage: " + bc.getSpritDmg());
        ailmentDmgLabel.setText("Ailment Damage: " + bc.getAilmentDmg());
    }

    private void setDefault(){
        dropdownMenu.setValue("Bankai Ichigo");
        var defaultImg = getClass().getResource(
                "/com/bsrshard/org/bsrshardorggui/media/characterImages/Bankai Ichigo.png"
        );
        imageView.setImage(new Image(defaultImg.toString()));
        setCharacter(Objects.requireNonNull(CharacterList.getCharacterList().stream()
                .filter(c -> c.getName().equals("Bankai Ichigo"))
                .findFirst()
                .orElse(null)));
    }

    public void importFileDialog(){
        FileReader.getInstance().readShardData(View.getPrimaryStage());
    }

    private void setCellFactoryValue(){

        idColumn.setCellValueFactory(p ->
                new ReadOnlyObjectWrapper<>()
        );

        hpColumn.setCellValueFactory(p ->
                new ReadOnlyObjectWrapper<>()
        );

        defColumn.setCellValueFactory(p ->
                new ReadOnlyObjectWrapper<>()
        );

        attackColumn.setCellValueFactory(p ->
                new ReadOnlyObjectWrapper<>()
        );


        critRateColumn.setCellValueFactory(p ->
                new ReadOnlyObjectWrapper<>()
        );

        critDmgColumn.setCellValueFactory(p ->
                new ReadOnlyObjectWrapper<>()
        );

        ailmentDmgColumn.setCellValueFactory(p ->
                new ReadOnlyObjectWrapper<>()
        );

        slashDmgColumn.setCellValueFactory(p ->
                new ReadOnlyObjectWrapper<>()
        );

        strikeDmgColumn.setCellValueFactory(p ->
                new ReadOnlyObjectWrapper<>()
        );

        thrustDmgColumn.setCellValueFactory(p ->
                new ReadOnlyObjectWrapper<>()
        );

        spiritDmgColumn.setCellValueFactory(p ->
                new ReadOnlyObjectWrapper<>()
        );

        ultimateCRateColumn.setCellValueFactory(p ->
                new ReadOnlyObjectWrapper<>()
        );
    }

    public void initialize(){
        createChar();
        dropdownMenu.getItems().addAll("Bankai Ichigo", "Aizen");
        setDefault();
        treeTableView.setColumnResizePolicy(TreeTableView.CONSTRAINED_RESIZE_POLICY);

        //setCellFactoryValue(ShardList.getShardList().getFirst());

        dropdownMenu.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            var url = getClass().getResource(
                    "/com/bsrshard/org/bsrshardorggui/media/characterImages/" + newVal + ".png"
            );
            imageView.setImage(new Image(url.toString()));
            for(BleachCharacter bc : CharacterList.getCharacterList()){
                if(Objects.equals(bc.getName(), newVal)){
                    setCharacter(bc);
                }else{
                    setCharacter(new BleachCharacter("", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
                }
                break;
            }
        });
    }

}