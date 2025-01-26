/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package wizardsarefun;

import Controller.CollisionUtils;
import Controller.GameManager;
import Controller.Logica;
import Controller.SoundController;
import Model.Enemy;
import Model.Player;
import Model.Projectile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import java.io.File;
import java.util.Optional;
import javafx.animation.FadeTransition;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import static javafx.scene.input.KeyCode.A;
import static javafx.scene.input.KeyCode.D;
import static javafx.scene.input.KeyCode.DOWN;
import static javafx.scene.input.KeyCode.LEFT;
import static javafx.scene.input.KeyCode.NUMPAD0;
import static javafx.scene.input.KeyCode.PAGE_DOWN;
import static javafx.scene.input.KeyCode.RIGHT;
import static javafx.scene.input.KeyCode.S;
import static javafx.scene.input.KeyCode.SPACE;
import static javafx.scene.input.KeyCode.UP;
import static javafx.scene.input.KeyCode.W;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.Media;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author kkrc9
 */
public class WizardsAreFun extends Application {
    private Stage primaryStage;
    private Scene menuScene;
    private Scene characterScene;
    private Scene gameScene;
    private Scene gameOverScene;
    private Logica logica;
    private Group root;
    private SoundController soundController;

    private List<String[]> characterAnimations; // Stores walking animation frames for each character
    private int currentCharacterIndexP1 = 0; // Tracks Player 1's selected character
    private int currentCharacterIndexP2 = 1; // Tracks Player 2's selected character (starts on a different character)
    private ImageView characterImageViewP1; // Displays Player 1's character animation
    private ImageView characterImageViewP2; // Displays Player 2's character animation
    private Timeline animationTimelineP1; // Plays Player 1's walking animation
    private Timeline animationTimelineP2; // Plays Player 2's walking animation
    
    private MediaPlayer backgroundMusicPlayer;

    private boolean isMultiplayer = false; // Tracks whether the game is in multiplayer mode
    private GameManager gameManager;
    private Player player1;
    private Player player2;
    private Label player1PointsLabel;
    private Label player2PointsLabel;
    private Label chooseYourCharacter;
    private Label startGameLabel;
    private Label goBackLabel;
    private Label pressLabel;
    
    private Button buttonA;
    private Button buttonD;
    private Button buttonLeft;
    private Button buttonRight;
    private Button buttonSpace;
    
    private double spawnInterval = 5.0; // Initial spawn interval (seconds)
    private double timeSinceLastSpawn = 0.0; // Time since the last enemy was spawned
    private double gameTime = 0.0; // Total elapsed game time
    private long lastUpdateTime = 0; // Used to calculate delta time

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        logica = new Logica();
        soundController = new SoundController();
        
        // Play the background music as soon as the app starts
        playBackgroundMusic();

        characterAnimations = new ArrayList<>();
        characterAnimations.add(logica.getCharacterASelection());
        characterAnimations.add(logica.getCharacterBSelection());
        characterAnimations.add(logica.getCharacterCSelection());
        characterAnimations.add(logica.getCharacterDSelection());
        characterAnimations.add(logica.getCharacterESelection());
        characterAnimations.add(logica.getCharacterFSelection());

        // Create the menu scene
        createMenuScene();

        // Set the initial scene to the menu
        primaryStage.setScene(menuScene);
        primaryStage.setTitle("Wizards Are Fun!");
        primaryStage.show();
    }

    private void createMenuScene() {
        // Create the background ImageView
        ImageView titleBackground = new ImageView(new Image(new File("src/Media/WizardsAreFunTitleScreen.jpg").toURI().toString()));
        titleBackground.setFitHeight(1024); 
        titleBackground.setFitWidth(1024);

        // Create the buttons
        Button singleplayerButton = new Button("Singleplayer");
        Button multiplayerButton = new Button("Multiplayer");
        Button exitButton = new Button("Exit");
        
        singleplayerButton.setPrefWidth(300); 
        multiplayerButton.setPrefWidth(300);
        exitButton.setPrefWidth(300);
        
        // Apply CSS to the buttons
        String transparentButtonStyle = 
            "-fx-background-color: transparent; " + 
            "-fx-border-color: transparent; " +
            "-fx-text-fill: rgb(229,157,37); " +
            "-fx-font-size: 20px; " +
            "-fx-padding: 2;" +
            "-fx-font-weight: bold;" +
            "-fx-cursor: hand;" +
            "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.8), 10, 0.4, 0, 0);" + 
            "-fx-transition: all 0.3s ease;";
        
        // Hover style with drop shadow and text color change
        String hoverStyle = 
            "-fx-text-fill: white; " + // Change text color to white on hover
            "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.8), 10, 0.8, 0, 0);";
        
        // Style the buttons
        singleplayerButton.setStyle(transparentButtonStyle);
        multiplayerButton.setStyle(transparentButtonStyle);
        exitButton.setStyle(transparentButtonStyle);
        
        // Add hover effects
        singleplayerButton.setOnMouseEntered(e -> singleplayerButton.setStyle(transparentButtonStyle + hoverStyle));
        singleplayerButton.setOnMouseExited(e -> singleplayerButton.setStyle(transparentButtonStyle));

        multiplayerButton.setOnMouseEntered(e -> multiplayerButton.setStyle(transparentButtonStyle + hoverStyle));
        multiplayerButton.setOnMouseExited(e -> multiplayerButton.setStyle(transparentButtonStyle));

        exitButton.setOnMouseEntered(e -> exitButton.setStyle(transparentButtonStyle + hoverStyle));
        exitButton.setOnMouseExited(e -> exitButton.setStyle(transparentButtonStyle));
        
        // Create a VBox to hold the buttons
        VBox buttonLayout = new VBox(18);
        buttonLayout.setAlignment(Pos.BOTTOM_CENTER);
        buttonLayout.getChildren().addAll(singleplayerButton, multiplayerButton, exitButton);

        // Adjust the position of the VBox containing the buttons
        buttonLayout.setTranslateY(-46);
        
        StackPane menuLayout = new StackPane();
        menuLayout.getChildren().addAll(titleBackground, buttonLayout); // Background first, buttons on top  
        
        // Create the scene
        menuScene = new Scene(menuLayout, 1024, 1024);
        
        // Singleplayer button action
        singleplayerButton.setOnAction(e -> {
            isMultiplayer = false;
            showCharacterSelection();
        });

        // Multiplayer button action
        multiplayerButton.setOnAction(e -> {
            isMultiplayer = true;
            showCharacterSelection();
        });

        // Exit button action
        exitButton.setOnAction(e -> primaryStage.close());
    }

    private void showCharacterSelection() {
        // Create the background ImageView
        ImageView chooseCharacterBackground = new ImageView(new Image(new File("src/Media/CharacterSelectScreen.jpg").toURI().toString()));
        chooseCharacterBackground.setFitHeight(1024); 
        chooseCharacterBackground.setFitWidth(1024);
        
        // Title Label
        chooseYourCharacter = new Label("CHOOSE YOUR CHARACTER");
        HBox chooseCharacterLabel = new HBox(chooseYourCharacter);
        chooseCharacterLabel.setAlignment(Pos.TOP_CENTER);
        
        // Apply CSS to the buttons
        String chooseCharacterStyle = 
            "-fx-text-fill: rgb(255, 255, 51); " +
            "-fx-font-size: 50px; " +
            "-fx-padding: 2;" +
            "-fx-font-weight: bold;" +
            "-fx-cursor: hand;" +
            "-fx-effect: dropshadow(gaussian, rgba(255, 191, 128,0.8), 10, 0.4, 0, 0);" + 
            "-fx-transition: all 0.3s ease;" +
            "-fx-font-family: 'Lucida Console', 'Courier New', monospace;";
        chooseYourCharacter.setStyle(chooseCharacterStyle);
        chooseYourCharacter.setTranslateY(188);
        
        // Root layout
        StackPane characterLayout = new StackPane();
        characterLayout.setAlignment(Pos.CENTER);

        // Create Player 1's character image view
        characterImageViewP1 = new ImageView();
        characterImageViewP1.setFitWidth(384); // Adjust size as needed
        characterImageViewP1.setFitHeight(384);

        // Create Player 2's character image view (only for multiplayer)
        characterImageViewP2 = new ImageView();
        characterImageViewP2.setFitWidth(384); // Adjust size as needed
        characterImageViewP2.setFitHeight(384);

        // Load the initial character animations
        loadCharacterAnimation(characterImageViewP1, currentCharacterIndexP1, true);
        if (isMultiplayer) {
            loadCharacterAnimation(characterImageViewP2, currentCharacterIndexP2, false);
        }

        // Character images layout
        HBox characterBox = new HBox(10, characterImageViewP1);
        characterBox.setAlignment(Pos.CENTER);
        if (isMultiplayer) {
            characterBox.getChildren().add(characterImageViewP2);
        }
        
        // Buttons for Key Control
        buttonA = createKeyButton("src/Media/KeyboardKeys/lightKeys_A.png", "src/Media/KeyboardKeys/darkKeys_A.png");
        buttonD = createKeyButton("src/Media/KeyboardKeys/lightKeys_D.png", "src/Media/KeyboardKeys/darkKeys_D.png");
        buttonLeft = createKeyButton("src/Media/KeyboardKeys/lightKeys_left.png", "src/Media/KeyboardKeys/darkKeys_left.png");
        buttonRight = createKeyButton("src/Media/KeyboardKeys/lightKeys_right.png", "src/Media/KeyboardKeys/darkKeys_right.png");
        buttonSpace = createKeyButton("src/Media/KeyboardKeys/lightKeys_space.png", "src/Media/KeyboardKeys/darkKeys_space.png");

        // Button actions
        buttonA.setOnAction(e -> navigateCharacter(true, -1));
        buttonD.setOnAction(e -> navigateCharacter(true, 1));
        buttonLeft.setOnAction(e -> navigateCharacter(false, -1));
        buttonRight.setOnAction(e -> navigateCharacter(false, 1));
        buttonSpace.setOnAction(e -> startGame(isMultiplayer, currentCharacterIndexP1, currentCharacterIndexP2));

        // Layout for buttons
        HBox keyPressButtons = new HBox(85, buttonA, buttonD);
        if (isMultiplayer) {
            keyPressButtons.getChildren().addAll(buttonLeft, buttonRight);
        }
        keyPressButtons.setAlignment(Pos.BOTTOM_CENTER);
        keyPressButtons.setTranslateY(-250);
        
        pressLabel = new Label("Press ");
        pressLabel.setStyle(chooseCharacterStyle);
        startGameLabel = new Label(" to Start Game");
        startGameLabel.setStyle(chooseCharacterStyle);
        goBackLabel = new Label("Press <Esc> to Go Back");
        goBackLabel.setStyle(chooseCharacterStyle);
        
        HBox startGame = new HBox(10, pressLabel, buttonSpace, startGameLabel);
        startGame.setAlignment(Pos.CENTER);
        VBox controlBox = new VBox(10, startGame, goBackLabel);
        controlBox.setAlignment(Pos.BOTTOM_CENTER);
        controlBox.setTranslateY(-20);
        
        // Add everything to the layout
        characterLayout.getChildren().addAll(chooseCharacterBackground, chooseCharacterLabel, characterBox, keyPressButtons, controlBox);
        characterScene = new Scene(characterLayout, 1024, 1024);

        // Set key listeners
        characterScene.setOnKeyPressed(e -> handleKeyPress(e.getCode()));
        characterScene.setOnKeyReleased(e -> handleKeyRelease(e.getCode()));
        primaryStage.setScene(characterScene);

        primaryStage.setScene(characterScene);
        characterScene.getRoot().requestFocus();
    }

    private void loadCharacterAnimation(ImageView imageView, int characterIndex, boolean isPlayer1) {
        // Stop the current animation
        if (isPlayer1 && animationTimelineP1 != null) {
            animationTimelineP1.stop();
        } else if (!isPlayer1 && animationTimelineP2 != null) {
            animationTimelineP2.stop();
        }

        // Load the new character's animation frames
        String[] frames = characterAnimations.get(characterIndex);
        Image[] animationFrames = new Image[frames.length];
        for (int i = 0; i < frames.length; i++) { 
            animationFrames[i] = new Image(new File(frames[i]).toURI().toString());
        }

        // Set up the animation timeline
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.millis(150), e -> {
                    int frameIndex = (int) (System.currentTimeMillis() / 150 % frames.length);
                    imageView.setImage(animationFrames[frameIndex]);
                })
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        if (isPlayer1) {
            animationTimelineP1 = timeline;
        } else {
            animationTimelineP2 = timeline;
        }
    }

    private void startGame(boolean isMultiplayer, int characterIndexP1, int characterIndexP2) {
        System.out.println("Starting " + (isMultiplayer ? "multiplayer" : "singleplayer") + " game");
        System.out.println("Player 1 selected character: " + characterIndexP1);
        if (isMultiplayer) {
            System.out.println("Player 2 selected character: " + characterIndexP2);
        }
        
        // Initialize the game scene
        root = new Group();
        gameScene = new Scene(root, 1024, 1024, Color.DIMGREY);
        
        gameManager = new GameManager(root, gameScene, logica, this);
        gameManager.setPrimaryStage(primaryStage);
        
        // Initialize players based on selected characters
        player1 = createPlayer(characterIndexP1, 488, 488, gameManager);
        gameManager.setPlayer1(player1);

        if (isMultiplayer) {
            player1.setX(232);
            player2 = createPlayer(characterIndexP2, 744, 488, gameManager);
            player2.setDeathAnimation(logica.getPlayer2DeathAnimation()); // Set Player 2 death animation
            gameManager.setPlayer2(player2);

            player2.getSpriteView().setX(player2.getX());
            player2.getSpriteView().setY(player2.getY());
            player2.getSpriteView().setFitHeight(48); 
            player2.getSpriteView().setFitWidth(48);
            root.getChildren().add(player2.getSpriteView());
        }

        player1.getSpriteView().setX(player1.getX());
        player1.getSpriteView().setY(player1.getY());
        player1.getSpriteView().setFitHeight(48); 
        player1.getSpriteView().setFitWidth(48);
        root.getChildren().add(player1.getSpriteView());

        // Add the points labels to the scene
        player1PointsLabel = new Label("Player 1 Points: 0");
        player1PointsLabel.setStyle("-fx-font-size: 24px; -fx-text-fill: white;");
        player1PointsLabel.setLayoutX(20);
        player1PointsLabel.setLayoutY(20);
        root.getChildren().add(player1PointsLabel);

        if (isMultiplayer) {
            player2PointsLabel = new Label("Player 2 Points: 0");
            player2PointsLabel.setStyle("-fx-font-size: 24px; -fx-text-fill: white;");
            player2PointsLabel.setLayoutX(784);
            player2PointsLabel.setLayoutY(20);
            root.getChildren().add(player2PointsLabel);
        }

        // Transition to the game scene
        createGameScene(isMultiplayer, characterIndexP1, characterIndexP2);
        primaryStage.setScene(gameScene);
    }

    private void createGameScene(boolean isMultiplayer, int characterIndexP1, int characterIndexP2) {
        // Create the background ImageView
        ImageView chooseGameBackground = new ImageView(new Image(new File("src/Media/GameMap.jpg").toURI().toString()));
        chooseGameBackground.setFitHeight(1024); 
        chooseGameBackground.setFitWidth(1024);

        // Initialize the game scene based on the selected character/s
        root = new Group();
        root.getChildren().add(chooseGameBackground);
        gameScene = new Scene(root, 1024, 1024, Color.DIMGREY);
        gameManager = new GameManager(root, gameScene, logica, this);
        
        // Initialize players based on selected characters
        player1 = createPlayer(characterIndexP1, 488, 488, gameManager);
        gameManager.setPlayer1(player1);
        
        if (isMultiplayer) {
            player1.setX(232);
            player2 = createPlayer(characterIndexP2, 744, 488, gameManager);
            gameManager.setPlayer2(player2);

            player2.getSpriteView().setX(player2.getX());
            player2.getSpriteView().setY(player2.getY());
            player2.getSpriteView().setFitHeight(48); 
            player2.getSpriteView().setFitWidth(48);
            root.getChildren().add(player2.getSpriteView());
        }
        player1.getSpriteView().setX(player1.getX());
        player1.getSpriteView().setY(player1.getY());
        player1.getSpriteView().setFitHeight(48); 
        player1.getSpriteView().setFitWidth(48);
        root.getChildren().add(player1.getSpriteView());
        
        // Add the points labels to the scene
        // Initialize the points labels
        player1PointsLabel = new Label("Player 1 Points: 0");
        player1PointsLabel.setStyle("-fx-font-size: 24px; -fx-text-fill: white;"); // Style the label
        HBox playerInformationBox = new HBox(275);
        playerInformationBox.setAlignment(Pos.CENTER);
        
        HBox player1InfoBox = new HBox(20, player1PointsLabel);
        HBox player2InfoBox = new HBox(20);
        
        // Add hearts for Player 1
        HBox player1Hearts = createHeartsHBox(player1.getLives(), logica.getHeartLifeAnimation());
        player1Hearts.setId("player1Hearts");
        player1InfoBox.getChildren().add(player1Hearts);

        playerInformationBox.getChildren().add(player1InfoBox);
        
        HBox player2Hearts = new HBox();
        if (isMultiplayer) {
            player2PointsLabel = new Label("Player 2 Points: 0");
            player2PointsLabel.setStyle("-fx-font-size: 24px; -fx-text-fill: white;"); // Style the label
            player2Hearts = createHeartsHBox(player2.getLives(), logica.getHeartLifeAnimation());
            player2Hearts.setId("player2Hearts");
            player2InfoBox.getChildren().addAll(player2Hearts, player2PointsLabel);
            playerInformationBox.getChildren().add(player2InfoBox);
        }
        
        // Center the playerInformationBox within the root layout
        playerInformationBox.setLayoutX(50);
        playerInformationBox.setLayoutY(15);
        
        root.getChildren().add(playerInformationBox);
                        
        // Player movement
        gameScene.setOnKeyPressed(event -> {
            if (!player1.isInputEnabled() || (isMultiplayer && !player2.isInputEnabled())) {
                return; // Ignore key releases if input is disabled
            }
            switch (event.getCode()) {
                case W: 
                    player1.setVelocityY(-player1.getSpeed()); 
                    player1.setFacingDirection("UP"); 
                    break;
                case S: 
                    player1.setVelocityY(player1.getSpeed()); 
                    player1.setFacingDirection("DOWN"); 
                    break;
                case A: 
                    player1.setVelocityX(-player1.getSpeed()); 
                    player1.setFacingDirection("LEFT"); 
                    break;
                case D: 
                    player1.setVelocityX(player1.getSpeed()); 
                    player1.setFacingDirection("RIGHT"); 
                    break;
                case UP: 
                    player2.setVelocityY(-player1.getSpeed()); 
                    player2.setFacingDirection("UP"); 
                    break;
                case DOWN: 
                    player2.setVelocityY(player1.getSpeed()); 
                    player2.setFacingDirection("DOWN"); 
                    break;
                case LEFT: 
                    player2.setVelocityX(-player1.getSpeed()); 
                    player2.setFacingDirection("LEFT"); 
                    break;
                case RIGHT: 
                    player2.setVelocityX(player1.getSpeed()); 
                    player2.setFacingDirection("RIGHT"); 
                    break;
                case ESCAPE:
                    handleEscKey(gameScene);
            }
        });

        gameScene.setOnKeyReleased(event -> {
            if (!player1.isInputEnabled() || (isMultiplayer && !player2.isInputEnabled())) {
                return; // Ignore key releases if input is disabled
            }
            switch (event.getCode()) {
                case W: case S: player1.setVelocityY(0); break;
                case A: case D: player1.setVelocityX(0); break;
                case UP: case DOWN: 
                    if (isMultiplayer) player2.setVelocityY(0); 
                    break;
                case LEFT: case RIGHT: 
                    if (isMultiplayer) player2.setVelocityX(0); 
                    break;
                case SPACE:
                    double startX1 = player1.getSpriteView().getX();
                    double startY1 = player1.getSpriteView().getY();
                    Projectile projectile1 = new Projectile(startX1, startY1, player1.getFacingDirection(), logica.getFireballFrames(), player1);
                    soundController.playSound("src/Media/Music/fireballWhoosh.mp3");
                    gameManager.addProjectile(projectile1);
                    break;
                case NUMPAD0:
                case PAGE_DOWN: // My keyboard doesnt have the numpad so I had to test with this key
                    if (isMultiplayer) {
                        double startX2 = player2.getSpriteView().getX();
                        double startY2 = player2.getSpriteView().getY();
                        Projectile projectile2 = new Projectile(startX2, startY2, player2.getFacingDirection(), logica.getFireballFrames(), player2);
                        soundController.playSound("src/Media/Music/fireballWhoosh.mp3");
                        gameManager.addProjectile(projectile2);
                        break;
                    }
            }
        });
            
        AnimationTimer gameLoop = new AnimationTimer() {
            @Override
            public void handle(long now) {
                gameManager.setGameLoop(this); // Pass the game loop to GameManager

                // Calculate delta time (time since last frame in seconds)
                double deltaTime = (now - lastUpdateTime) / 1_000_000_000.0; // Convert nanoseconds to seconds
                lastUpdateTime = now;
                
                // Update game time and time since last spawn
                gameTime += deltaTime;
                timeSinceLastSpawn += deltaTime;
                
                // Spawn enemies based on the current interval
                if (timeSinceLastSpawn >= spawnInterval) {
                    gameManager.spawnEnemy();
                    timeSinceLastSpawn = 0.0; // Reset the timer

                    // Gradually increase spawn rate over time
                    if (gameTime % 30 == 0) { // Every 30 seconds
                        spawnInterval = Math.max(1.0, spawnInterval - 0.1); // Don't go below 1 second
                        System.out.println("Spawn interval decreased to: " + spawnInterval);
                    }
                }
                
                // Update player movement
                player1.updatePosition(gameScene); 
                if (isMultiplayer) {
                    player2.updatePosition(gameScene);
                }

                // Check if players are dead
                if (player1.isDead() || (isMultiplayer && player2.isDead())) {
                    this.stop();
                }

                // Move projectiles
                for (int i = 0; i < gameManager.getProjectiles().size(); i++) {
                    Projectile p = gameManager.getProjectiles().get(i);
                    p.move();

                    // Remove if out of bounds
                    if (p.isOutOfBounds(gameScene)) {
                        gameManager.removeProjectile(p);
                        i--; // Adjust index after removal
                    }
                }

                // Move enemies toward player
                Iterator<Enemy> iterator = gameManager.getEnemies().iterator();
                while (iterator.hasNext()) {
                    Enemy enemy = iterator.next();
                    
                    // Skip dead enemies (those without a hitbox)
                    if (enemy.getHitbox() == null) {
                        continue;
                    }

                    if (player1.getHealth() <= 0 || (isMultiplayer && player2.getHealth() <= 0)) {
                        break; // Exit the loop if the player is dead
                    }

                    // Update enemy movement to follow the nearest player
                    Player targetPlayer = getNearestPlayer(enemy, player1, player2, isMultiplayer);
                    enemy.moveTowardPlayer(targetPlayer, gameScene); 

                    // Collision detection with player1
                    if (CollisionUtils.checkCollision(player1.getHitbox(), enemy.getHitbox())) {
                        player1.takeDamage(25); // Handle player damage
                        if (player1.getHealth() <= 0){
                            player1.setDead(true);
                        }
                        // Optional: Handle enemy behavior on collision (e.g., bounce back, deal damage)
                    }
                    // Collision detection with player2
                    if (isMultiplayer && CollisionUtils.checkCollision(player2.getHitbox(), enemy.getHitbox())) {
                        player2.takeDamage(25); // Handle player damage
                        if (player2.getHealth() <= 0){
                            player2.setDead(true);
                        }
                        // Optional: Handle enemy behavior on collision (e.g., bounce back, deal damage)
                    }
                }
                if (player1.isDead() || (isMultiplayer && player2.isDead())){
                    gameManager.removeAllEnemies();
                }

                // Damage and Collision handling Projectile to Enemies
                for (Iterator<Projectile> projectileIterator = gameManager.getProjectiles().iterator(); projectileIterator.hasNext(); ) {
                    Projectile projectile = projectileIterator.next();
                    for (Enemy enemy : gameManager.getEnemies()) {
                        // Skip dead enemies (those without a hitbox)
                        if (enemy.getHitbox() == null) {
                            continue;
                        }
                        
                        // Check if the hitboxes intersect
                        if (CollisionUtils.checkCollision(projectile.getHitbox(), enemy.getHitbox())) {
                            enemy.takeDamage(1, projectile.getShooter()); // Apply damage
                            
                            // Update the points label(s)
                            if (isMultiplayer) {
                                updatePointsLabels(); // Update both players' points labels
                            } else {
                                updatePointsLabel(); // Update only player1's points label
                            }

                            // Remove projectile safely using the iterator
                            projectileIterator.remove();
                            gameManager.removeProjectile(projectile); // Keep game manager state consistent
                            break; // Exit inner loop after collision
                        }
                    }
                }
            }
        };
        if (!player1.isDead() && (!isMultiplayer || !player2.isDead())){
            gameLoop.start();
        }
    }
    
    private void createGameOverScene() {
        // Load the game over background image
        ImageView gameOverBackground = new ImageView(new Image(new File("src/Media/GameOverScreen.jpg").toURI().toString()));
        gameOverBackground.setFitHeight(1024);
        gameOverBackground.setFitWidth(1024);

        // Create labels for instructions
        Label player1PointsLabel = new Label("Player 1 Points: " + (player1 != null ? player1.getPoints() : 0));
        Label player2PointsLabel = new Label("Player 2 Points: " + (player2 != null ? player2.getPoints() : 0));
        pressLabel = new Label("Press ");
        Label playAgainLabel = new Label(" to Play Again");
        Label pressEscLabel = new Label("Press ESC to Return to Main Menu");

        // Style the labels
        String labelStyle = 
            "-fx-text-fill: rgb(255, 255, 51); " +
            "-fx-font-size: 50px; " +
            "-fx-padding: 2;" +
            "-fx-font-weight: bold;" +
            "-fx-cursor: hand;" +
            "-fx-effect: dropshadow(gaussian, rgba(255, 191, 128,0.8), 10, 0.4, 0, 0);" + 
            "-fx-transition: all 0.3s ease;" +
            "-fx-font-family: 'Lucida Console', 'Courier New', monospace;";

        player1PointsLabel.setStyle(labelStyle);
        player2PointsLabel.setStyle(labelStyle);
        pressLabel.setStyle(labelStyle);
        playAgainLabel.setStyle(labelStyle);
        pressEscLabel.setStyle(labelStyle);
        
        // Create the Space button
        buttonSpace = createKeyButton("src/Media/KeyboardKeys/lightKeys_space.png", "src/Media/KeyboardKeys/darkKeys_space.png");
        buttonSpace.setOnAction(e -> startGame(isMultiplayer, currentCharacterIndexP1, currentCharacterIndexP2));

        // Position the labels
        VBox scoreLabelBox = new VBox(25, player1PointsLabel);
        if (isMultiplayer) scoreLabelBox.getChildren().add(player2PointsLabel);
        scoreLabelBox.setAlignment(Pos.TOP_CENTER);
        scoreLabelBox.setTranslateY(50);
        HBox labelBoxH = new HBox(pressLabel, buttonSpace, playAgainLabel);
        labelBoxH.setAlignment(Pos.CENTER);
        VBox labelBoxV = new VBox(20, labelBoxH, pressEscLabel);
        labelBoxV.setAlignment(Pos.BOTTOM_CENTER);
        labelBoxV.setTranslateY(-100); // Adjust vertical position

        // Create the root layout
        StackPane gameOverLayout = new StackPane();
        gameOverLayout.getChildren().addAll(gameOverBackground, scoreLabelBox, labelBoxV);

        // Create the scene
        gameOverScene = new Scene(gameOverLayout, 1024, 1024);

        // Set key listeners for the game over scene
        gameOverScene.setOnKeyPressed(event -> handleGameOverKeyPress(event.getCode()));
    }
    
    public void showGameOverScene() {
        createGameOverScene();
        
        // Create a fade transition for the game over scene
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), gameOverScene.getRoot());
        fadeTransition.setFromValue(0); // Start fully transparent
        fadeTransition.setToValue(1);   // End fully opaque
        
        primaryStage.setScene(gameOverScene);
        fadeTransition.play();
        
        gameOverScene.getRoot().requestFocus(); // Ensure the game over scene has focus
    }
    
    private void updatePointsLabel() {
        player1PointsLabel.setText("Player 1 Points: " + player1.getPoints());
    }

    private void updatePointsLabels() {
        player1PointsLabel.setText("Player 1 Points: " + player1.getPoints());
        player2PointsLabel.setText("Player 2 Points: " + player2.getPoints());
    }
    
    private Player getNearestPlayer(Enemy enemy, Player player1, Player player2, boolean isMultiplayer) {
        double dx1 = player1.getSpriteView().getX() - enemy.getSpriteView().getX();
        double dy1 = player1.getSpriteView().getY() - enemy.getSpriteView().getY();
        double distanceSquaredToPlayer1 = dx1 * dx1 + dy1 * dy1;

        if (!isMultiplayer) {
            return player1;
        }

        double dx2 = player2.getSpriteView().getX() - enemy.getSpriteView().getX();
        double dy2 = player2.getSpriteView().getY() - enemy.getSpriteView().getY();
        double distanceSquaredToPlayer2 = dx2 * dx2 + dy2 * dy2;

        return (distanceSquaredToPlayer1 < distanceSquaredToPlayer2) ? player1 : player2;
    }
    
    private Player createPlayer(int characterIndex, double x, double y, GameManager gameManager) {
        Player newPlayer;
        switch (characterIndex) {
            case 0:
                newPlayer = new Player(logica.getCharacterAIdleUP(), logica.getCharacterAIdleDOWN(), 
                logica.getCharacterAIdleLEFT(), logica.getCharacterAIdleRIGHT(), logica.getCharacterAWalkUP(), 
                logica.getCharacterAWalkDOWN(), logica.getCharacterAWalkLEFT(), logica.getCharacterAWalkRIGHT(),
                logica.getPlayer1DeathAnimation(), x, y, gameManager);
                break;
            case 1:
                newPlayer = new Player(logica.getCharacterBIdleUP(), logica.getCharacterBIdleDOWN(), 
                logica.getCharacterBIdleLEFT(), logica.getCharacterBIdleRIGHT(), logica.getCharacterBWalkUP(), 
                logica.getCharacterBWalkDOWN(), logica.getCharacterBWalkLEFT(), logica.getCharacterBWalkRIGHT(),
                logica.getPlayer1DeathAnimation(), x, y, gameManager);
                break;
            case 2:
                newPlayer = new Player(logica.getCharacterCIdleUP(), logica.getCharacterCIdleDOWN(), 
                logica.getCharacterCIdleLEFT(), logica.getCharacterCIdleRIGHT(), logica.getCharacterCWalkUP(), 
                logica.getCharacterCWalkDOWN(), logica.getCharacterCWalkLEFT(), logica.getCharacterCWalkRIGHT(),
                logica.getPlayer1DeathAnimation(), x, y, gameManager);
                break;
            case 3:
                newPlayer = new Player(logica.getCharacterDIdleUP(), logica.getCharacterDIdleDOWN(), 
                logica.getCharacterDIdleLEFT(), logica.getCharacterDIdleRIGHT(), logica.getCharacterDWalkUP(), 
                logica.getCharacterDWalkDOWN(), logica.getCharacterDWalkLEFT(), logica.getCharacterDWalkRIGHT(),
                logica.getPlayer1DeathAnimation(), x, y, gameManager);
                break;
            case 4:
                newPlayer = new Player(logica.getCharacterEIdleUP(), logica.getCharacterEIdleDOWN(), 
                logica.getCharacterEIdleLEFT(), logica.getCharacterEIdleRIGHT(), logica.getCharacterEWalkUP(), 
                logica.getCharacterEWalkDOWN(), logica.getCharacterEWalkLEFT(), logica.getCharacterEWalkRIGHT(),
                logica.getPlayer1DeathAnimation(), x, y, gameManager);
                break;
            case 5:
                newPlayer = new Player(logica.getCharacterFIdleUP(), logica.getCharacterFIdleDOWN(), 
                logica.getCharacterFIdleLEFT(), logica.getCharacterFIdleRIGHT(), logica.getCharacterFWalkUP(), 
                logica.getCharacterFWalkDOWN(), logica.getCharacterFWalkLEFT(), logica.getCharacterFWalkRIGHT(),
                logica.getPlayer1DeathAnimation(), x, y, gameManager);
                break;
            default:
                throw new AssertionError();
        }
        
        return newPlayer;
    }

    private void navigateCharacter(boolean isPlayer1, int direction) {
        if (isPlayer1) {
            currentCharacterIndexP1 = (currentCharacterIndexP1 + direction + characterAnimations.size()) % characterAnimations.size();
            loadCharacterAnimation(characterImageViewP1, currentCharacterIndexP1, true);
        } else if (isMultiplayer) {
            currentCharacterIndexP2 = (currentCharacterIndexP2 + direction + characterAnimations.size()) % characterAnimations.size();
            loadCharacterAnimation(characterImageViewP2, currentCharacterIndexP2, false);
        }
    }

    private void handleKeyPress(KeyCode keyCode) {
        switch (keyCode) {
            case A -> {
                navigateCharacter(true, -1); // Navigate character
                ((ImageView) buttonA.getGraphic()).setImage(new Image(new File("src/Media/KeyboardKeys/darkKeys_A.png").toURI().toString())); // Set pressed image
                buttonA.setTranslateY(5); // Move button down slightly
            }
            case D -> {
                navigateCharacter(true, 1); // Navigate character
                ((ImageView) buttonD.getGraphic()).setImage(new Image(new File("src/Media/KeyboardKeys/darkKeys_D.png").toURI().toString())); // Set pressed image
                buttonD.setTranslateY(5); // Move button down slightly
            }
            case SPACE -> startGame(isMultiplayer, currentCharacterIndexP1, currentCharacterIndexP2);
            case LEFT -> {
                navigateCharacter(false, -1); // Navigate character for player 2
                ((ImageView) buttonLeft.getGraphic()).setImage(new Image(new File("src/Media/KeyboardKeys/darkKeys_left.png").toURI().toString())); // Set pressed image
                buttonLeft.setTranslateY(5); // Move button down slightly
            }
            case RIGHT -> {
                navigateCharacter(false, 1); // Navigate character for player 2
                ((ImageView) buttonRight.getGraphic()).setImage(new Image(new File("src/Media/KeyboardKeys/darkKeys_right.png").toURI().toString())); // Set pressed image
                buttonRight.setTranslateY(5); // Move button down slightly
            }
            case ESCAPE -> {
                handleEscKey(characterScene);
            }
            default -> {}
        }
    }

    private void handleKeyRelease(KeyCode keyCode) {
        switch (keyCode) {
            case A -> {
                ((ImageView) buttonA.getGraphic()).setImage(new Image(new File("src/Media/KeyboardKeys/lightKeys_A.png").toURI().toString())); // Set default image
                buttonA.setTranslateY(0); // Reset button position
            }
            case D -> {
                ((ImageView) buttonD.getGraphic()).setImage(new Image(new File("src/Media/KeyboardKeys/lightKeys_D.png").toURI().toString())); // Set default image
                buttonD.setTranslateY(0); // Reset button position
            }
            case LEFT -> {
                ((ImageView) buttonLeft.getGraphic()).setImage(new Image(new File("src/Media/KeyboardKeys/lightKeys_left.png").toURI().toString())); // Set default image
                buttonLeft.setTranslateY(0); // Reset button position
            }
            case RIGHT -> {
                ((ImageView) buttonRight.getGraphic()).setImage(new Image(new File("src/Media/KeyboardKeys/lightKeys_right.png").toURI().toString())); // Set default image
                buttonRight.setTranslateY(0); // Reset button position
            }
            default -> {}
        }
    }
    
    private void handleEscKey(Scene currentScene) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Return to Main Menu");
        alert.setHeaderText("Are you sure you want to return to the main menu?");
        alert.setContentText("Any progress will be lost.");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            primaryStage.setScene(menuScene); // Switch back to the main menu
            menuScene.getRoot().requestFocus(); // Ensure the menu scene has focus
        } else {
            currentScene.getRoot().requestFocus(); // Keep focus on the current scene
        }
    }
    
    private void handleGameOverKeyPress(KeyCode keyCode) {
        switch (keyCode) {
            case SPACE:
                // Restart the game
                startGame(isMultiplayer, currentCharacterIndexP1, currentCharacterIndexP2);
                break;
            case ESCAPE:
                // Return to the main menu
                primaryStage.setScene(menuScene);
                menuScene.getRoot().requestFocus(); // Ensure the menu scene has focus
                break;
            default:
                // Ignore other keys
                break;
        }
    }

    private Button createKeyButton(String defaultImagePath, String pressedImagePath) {
        Image defaultImage = new Image(new File(defaultImagePath).toURI().toString());
        Image pressedImage = new Image(new File(pressedImagePath).toURI().toString());
        ImageView imageView = new ImageView(defaultImage);
        Button button = new Button("", imageView);
        button.setStyle("-fx-background-color: transparent;");
        
        // Set up press and release events
        button.setOnMousePressed(e -> {
            imageView.setImage(pressedImage); // Change to pressed image
            button.setTranslateY(5); // Move button down slightly
        });

        button.setOnMouseReleased(e -> {
            imageView.setImage(defaultImage); // Change back to default image
            button.setTranslateY(5); // Reset button position
        });
        
        return button;
    }
    
    private void playBackgroundMusic() {
    // Load the background music file
    Media backgroundMusic = new Media(new File("src/Media/Music/Zombie.mp3").toURI().toString());

    // Create a MediaPlayer for the background music
    backgroundMusicPlayer = new MediaPlayer(backgroundMusic);

    // Set the volume to a lower level
    backgroundMusicPlayer.setVolume(0.1);

    // Loop the music indefinitely
    backgroundMusicPlayer.setCycleCount(MediaPlayer.INDEFINITE);

    // Play the background music
    backgroundMusicPlayer.play();
}
    
    private HBox createHeartsHBox(int lives, String[] heartFrames) {
        HBox heartsHBox = new HBox(5); // Spacing between hearts
        heartsHBox.setAlignment(Pos.CENTER_LEFT);

        // Load the heart animation frames
        Image[] heartImages = new Image[heartFrames.length];
        for (int i = 0; i < heartFrames.length; i++) {
            heartImages[i] = new Image(new File(heartFrames[i]).toURI().toString());
        }

        // Add hearts for each life
        for (int i = 0; i < lives; i++) {
            ImageView heartImageView = new ImageView(heartImages[0]); // Use the first frame
            heartImageView.setFitWidth(32); // Adjust size as needed
            heartImageView.setFitHeight(32);
            
            // Create a Timeline to animate the heart
            Timeline heartAnimation = new Timeline(
                new KeyFrame(Duration.millis(150), event -> {
                    int currentFrameIndex = (int) (System.currentTimeMillis() / 150 % heartImages.length);
                    heartImageView.setImage(heartImages[currentFrameIndex]);
                })
            );
            heartAnimation.setCycleCount(Timeline.INDEFINITE); // Loop indefinitely
            heartAnimation.play(); // Start the animation
            
            heartsHBox.getChildren().add(heartImageView);
        }

        return heartsHBox;
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}