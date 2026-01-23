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




    @FXML private TreeTableView<Shard> treeTableView;

    @FXML private TreeTableColumn<Integer,Integer> idColumn;
    @FXML private TreeTableColumn<Shard, Integer> hpColumn;
    @FXML private TreeTableColumn<Shard, Integer> defColumn;
    @FXML private TreeTableColumn<Shard, Integer> attackColumn;
    @FXML private TreeTableColumn<Shard, Double> critRateColumn;
    @FXML private TreeTableColumn<Shard, Double> critDmgColumn;
    @FXML private TreeTableColumn<Shard, Double> ailmentDmgColumn;
    @FXML private TreeTableColumn<Shard, Double> slashDmgColumn;
    @FXML private TreeTableColumn<Shard, Double> strikeDmgColumn;
    @FXML private TreeTableColumn<Shard, Double> thrustDmgColumn;
    @FXML private TreeTableColumn<Shard, Double> spiritDmgColumn;
    @FXML private TreeTableColumn<Shard, Double> ultimateCRateColumn;



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

    public void setCellFactoryValue(){

        ShardList.genShardCombination();
        int index = 0;

        idColumn.setCellValueFactory(p ->
                new ReadOnlyObjectWrapper<>(index)
        );

        hpColumn.setCellValueFactory(p ->
                new ReadOnlyObjectWrapper<>(p.getValue().getValue().getFlatHP())
        );

        defColumn.setCellValueFactory(p ->
                new ReadOnlyObjectWrapper<>(p.getValue().getValue().getFlatDef())
        );

        attackColumn.setCellValueFactory(p ->
                new ReadOnlyObjectWrapper<>(p.getValue().getValue().getFlatAttack())
        );


        critRateColumn.setCellValueFactory(p ->
                new ReadOnlyObjectWrapper<>(p.getValue().getValue().getCritRate())
        );

        critDmgColumn.setCellValueFactory(p ->
                new ReadOnlyObjectWrapper<>(p.getValue().getValue().getCritDmg())
        );

        ailmentDmgColumn.setCellValueFactory(p ->
                new ReadOnlyObjectWrapper<>(p.getValue().getValue().getAilmentDmg())
        );

        slashDmgColumn.setCellValueFactory(p ->
                new ReadOnlyObjectWrapper<>(p.getValue().getValue().getSlashDmg())
        );

        strikeDmgColumn.setCellValueFactory(p ->
                new ReadOnlyObjectWrapper<>(p.getValue().getValue().getStrikeDmg())
        );

        thrustDmgColumn.setCellValueFactory(p ->
                new ReadOnlyObjectWrapper<>(p.getValue().getValue().getThrustDmg())
        );

        spiritDmgColumn.setCellValueFactory(p ->
                new ReadOnlyObjectWrapper<>(p.getValue().getValue().getSpritDmg())
        );

        ultimateCRateColumn.setCellValueFactory(p ->
                new ReadOnlyObjectWrapper<>(p.getValue().getValue().getUltimateCRate())
        );

        buildTree();
    }

    private void buildTree() {
        // 1. Create a dummy root
        TreeItem<Shard> rootItem = new TreeItem<>(new Shard());

        // 2. Add your shards (Example: from a list or database)
        for (Shard shard : ShardList.getShardList()) {
            rootItem.getChildren().add(new TreeItem<>(shard));
        }

        // 3. Set the root and hide it
        treeTableView.setRoot(rootItem);
        treeTableView.setShowRoot(false);
    }

    public void initialize(){
        createChar();
        dropdownMenu.getItems().addAll("Bankai Ichigo", "Aizen");
        setDefault();
        treeTableView.setColumnResizePolicy(TreeTableView.CONSTRAINED_RESIZE_POLICY);

        // --- WARRIOR VARIATIONS (Focus: Balance / Defense / Attack) ---
        ShardList.addShard(new Shard("Metal Warrior I", 520, 8.0, 110, 6.0, 45, 12.0, 4.0, 8.0, 2.0, 4.0, 3.0, 1.0, 1.0, 4.0));
        ShardList.addShard(new Shard("Warrior I", 480, 12.0, 90, 4.0, 55, 9.0, 6.0, 12.0, 3.0, 2.0, 5.0, 2.0, 3.0, 6.0));
        ShardList.addShard(new Shard("Metal Warrior II", 570, 9.0, 120, 7.0, 52, 13.0, 5.0, 10.0, 2.5, 4.5, 3.5, 1.5, 1.5, 5.0));
        ShardList.addShard(new Shard("Warrior II", 530, 13.0, 100, 5.0, 58, 10.0, 7.0, 14.0, 3.5, 2.5, 5.5, 2.5, 3.5, 6.5));
        ShardList.addShard(new Shard("Metal Warrior III", 620, 10.0, 130, 8.0, 65, 14.0, 6.0, 12.0, 3.0, 5.0, 4.0, 2.0, 2.0, 6.0));
        ShardList.addShard(new Shard("Warrior III", 580, 15.0, 110, 6.0, 70, 11.0, 8.0, 16.0, 4.0, 3.0, 6.0, 3.0, 4.0, 8.0));

// --- MAGE VARIATIONS (Focus: Pure Power / Ailment / Critical) ---
        ShardList.addShard(new Shard("Mage I", 280, 5.0, 50, 2.0, 80, 18.0, 12.0, 25.0, 6.0, 5.0, 6.0, 1.0, 4.0, 9.0));
        ShardList.addShard(new Shard("Mage I", 310, 10.0, 70, 4.0, 65, 12.0, 8.0, 15.0, 4.0, 7.0, 8.0, 3.0, 2.0, 7.0));
        ShardList.addShard(new Shard("Mage II", 300, 6.0, 55, 2.5, 85, 20.0, 13.0, 28.0, 7.0, 5.5, 6.5, 1.5, 5.0, 10.0));
        ShardList.addShard(new Shard("Mage II", 330, 11.0, 75, 5.0, 70, 14.0, 9.0, 18.0, 5.0, 7.5, 8.5, 3.5, 3.0, 8.0));
        ShardList.addShard(new Shard("Mage III", 330, 7.0, 60, 3.0, 95, 22.0, 15.0, 30.0, 8.0, 6.0, 7.0, 2.0, 6.0, 12.0));
        ShardList.addShard(new Shard("Mage III", 370, 12.0, 80, 6.0, 85, 16.0, 11.0, 22.0, 6.0, 8.0, 9.0, 4.0, 4.0, 10.0));

// --- ROGUE VARIATIONS (Focus: Speed / Lethality / Multihit) ---
        ShardList.addShard(new Shard("Rogue I", 380, 10.0, 70, 3.0, 65, 14.0, 18.0, 30.0, 2.0, 3.0, 4.0, 3.0, 3.0, 7.0));
        ShardList.addShard(new Shard("Rogue I", 420, 14.0, 90, 5.0, 55, 10.0, 12.0, 20.0, 4.0, 5.0, 6.0, 1.0, 5.0, 5.0));
        ShardList.addShard(new Shard("Rogue II", 400, 11.0, 75, 3.5, 70, 15.0, 20.0, 35.0, 2.5, 3.5, 4.5, 3.5, 3.5, 8.0));
        ShardList.addShard(new Shard("Rogue II", 440, 15.0, 95, 5.5, 60, 11.0, 14.0, 25.0, 4.5, 5.5, 6.5, 1.5, 5.5, 6.0));
        ShardList.addShard(new Shard("Rogue III", 430, 12.0, 80, 4.0, 80, 18.0, 25.0, 45.0, 3.0, 4.0, 5.0, 4.0, 4.0, 10.0));
        ShardList.addShard(new Shard("Rogue III", 470, 16.0, 100, 6.0, 75, 13.0, 16.0, 30.0, 5.0, 6.0, 7.0, 2.0, 6.0, 7.5));

// --- PALADIN VARIATIONS (Focus: Immortality / Retribution / Aura) ---
        ShardList.addShard(new Shard("Paladin I", 650, 18.0, 140, 8.0, 35, 6.0, 3.0, 8.0, 1.0, 2.0, 2.0, 1.0, 2.0, 3.0));
        ShardList.addShard(new Shard("Paladin I", 550, 12.0, 100, 4.0, 45, 10.0, 7.0, 12.0, 2.0, 2.0, 4.0, 2.0, 1.0, 5.0));
        ShardList.addShard(new Shard("Paladin II", 700, 20.0, 150, 9.0, 40, 7.0, 4.0, 9.0, 1.5, 2.5, 2.5, 1.5, 2.5, 3.5));
        ShardList.addShard(new Shard("Paladin II", 600, 14.0, 110, 5.0, 50, 11.0, 8.0, 14.0, 2.5, 2.5, 4.5, 2.5, 1.5, 5.5));
        ShardList.addShard(new Shard("Paladin III", 750, 22.0, 160, 10.0, 50, 9.0, 5.0, 11.0, 2.0, 3.0, 3.0, 2.0, 3.0, 4.5));
        ShardList.addShard(new Shard("Paladin III", 650, 16.0, 120, 6.0, 60, 12.0, 9.0, 16.0, 3.0, 3.0, 5.0, 3.0, 2.0, 7.0));

// --- HUNTER VARIATIONS (Focus: Precision / Traps / Volley) ---
        ShardList.addShard(new Shard("Hunter I", 330, 7.0, 60, 2.5, 60, 13.0, 10.0, 20.0, 3.0, 2.0, 3.0, 2.0, 1.0, 8.0));
        ShardList.addShard(new Shard("Hunter I", 370, 11.0, 80, 4.5, 50, 9.0, 6.0, 15.0, 1.0, 4.0, 5.0, 1.0, 3.0, 6.0));
        ShardList.addShard(new Shard("Hunter II", 350, 8.0, 65, 3.0, 65, 14.5, 11.5, 23.0, 3.5, 2.5, 3.5, 2.5, 1.5, 9.0));
        ShardList.addShard(new Shard("Hunter II", 390, 12.0, 85, 5.0, 55, 10.5, 7.5, 17.0, 1.5, 4.5, 5.5, 1.5, 3.5, 7.0));
        ShardList.addShard(new Shard("Hunter III", 380, 9.0, 70, 3.5, 75, 16.0, 14.0, 28.0, 4.0, 3.0, 4.0, 3.0, 2.0, 11.0));
        ShardList.addShard(new Shard("Hunter III", 420, 13.0, 90, 6.0, 65, 12.0, 9.0, 20.0, 2.0, 5.0, 6.0, 2.0, 4.0, 8.5));
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