package com.sorveteria.sorveteria;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.*;
import java.util.stream.Collectors;

public class SorveteriaApp extends Application {

    private final Map<String, Double> sorvetePrecos = new LinkedHashMap<>() {{
        put("Chocolate", 8.50);
        put("Morango", 8.00);
        put("Baunilha", 7.50);
        put("Pistache", 10.00);
    }};

    private final Map<String, Double> picolePrecos = new LinkedHashMap<>() {{
        put("Limão", 5.00);
        put("Uva", 5.50);
        put("Coco", 6.00);
        put("Maracujá", 6.50);
    }};

    private final Map<String, Double> adicionaisPrecos = new LinkedHashMap<>() {{
        put("Chocolate", 1.00);
        put("Calda", 1.00);
        put("Granulado", 1.00);
        put("Frutas", 1.50);
    }};

    private double totalPrice = 0.0;

    private final Label totalPriceLabel = new Label("Total: R$ 0.00");
    private final TextArea selectionSummary = new TextArea();

    // CheckBoxes para sorvetes e picolés para fácil controle
    private final Map<String, CheckBox> sorveteCheckBoxes = new LinkedHashMap<>();
    private final Map<String, CheckBox> picoleCheckBoxes = new LinkedHashMap<>();

    // Map para armazenar adicionais selecionados por sabor de sorvete
    private final Map<String, Set<String>> adicionaisSelecionadosPorSorvete = new HashMap<>();

    private Button adicionaisButton;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Sorveteria");

        VBox initialScreen = createInitialScreen(primaryStage);

        Scene scene = new Scene(initialScreen, 600, 550);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private VBox createInitialScreen(Stage primaryStage) {
        VBox screen = new VBox(20);
        screen.setAlignment(Pos.CENTER);
        screen.setPadding(new Insets(30));
        screen.setStyle("-fx-background-color: #FFFFFF;");

        Label titleLabel = new Label("Sorveteria Delícia");
        titleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 28));
        titleLabel.setTextFill(Color.web("#FF69B4"));

        Button orderButton = new Button("Fazer Pedido");
        styleButton(orderButton);
        orderButton.setOnAction(e -> {
            VBox orderScreen = createOrderScreen(primaryStage);
            primaryStage.getScene().setRoot(orderScreen);
        });

        Button exitButton = new Button("Sair");
        styleButton(exitButton);
        exitButton.setOnAction(e -> primaryStage.close());

        screen.getChildren().addAll(titleLabel, orderButton, exitButton);
        return screen;
    }

    private VBox createOrderScreen(Stage primaryStage) {
        VBox screen = new VBox(15);
        screen.setPadding(new Insets(20));
        screen.setStyle("-fx-background-color: #FFFFFF;");

        Label titleLabel = new Label("Faça seu Pedido");
        titleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        titleLabel.setTextFill(Color.web("#FF69B4"));

        TitledPane sorveteSection = createFlavorSection("Sorvete", sorvetePrecos, sorveteCheckBoxes, true);
        TitledPane picoleSection = createFlavorSection("Picolé", picolePrecos, picoleCheckBoxes, false);

        Label summaryLabel = new Label("Itens Selecionados:");
        summaryLabel.setFont(Font.font("Arial", FontWeight.BOLD, 16));

        selectionSummary.setEditable(false);
        selectionSummary.setPrefHeight(130);
        selectionSummary.setStyle("-fx-control-inner-background: #F8F8F8; -fx-font-size: 14px;");

        totalPriceLabel.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        totalPriceLabel.setTextFill(Color.web("#FF69B4"));

        adicionaisButton = new Button("Adicionais");
        styleButton(adicionaisButton);
        adicionaisButton.setDisable(true);
        adicionaisButton.setOnAction(e -> openAdicionaisPopup());

        Button confirmButton = new Button("Confirmar Pedido");
        styleButton(confirmButton);
        confirmButton.setOnAction(e -> {
            if (totalPrice > 0) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Pedido Confirmado");
                alert.setHeaderText(null);
                alert.setContentText("Seu pedido foi confirmado!\nTotal: R$ " + String.format("%.2f", totalPrice));
                alert.showAndWait();

                // Resetar tudo
                totalPrice = 0.0;
                totalPriceLabel.setText("Total: R$ 0.00");
                selectionSummary.clear();
                adicionaisSelecionadosPorSorvete.clear();
                sorveteCheckBoxes.values().forEach(cb -> cb.setSelected(false));
                picoleCheckBoxes.values().forEach(cb -> cb.setSelected(false));
                updateAdicionaisButtonVisibility();

                VBox initialScreen = createInitialScreen(primaryStage);
                primaryStage.getScene().setRoot(initialScreen);
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Nenhum item selecionado");
                alert.setHeaderText(null);
                alert.setContentText("Por favor, selecione pelo menos um item.");
                alert.showAndWait();
            }
        });

        Button backButton = new Button("Voltar");
        styleButton(backButton);
        backButton.setOnAction(e -> {
            totalPrice = 0.0;
            totalPriceLabel.setText("Total: R$ 0.00");
            selectionSummary.clear();
            adicionaisSelecionadosPorSorvete.clear();
            sorveteCheckBoxes.values().forEach(cb -> cb.setSelected(false));
            picoleCheckBoxes.values().forEach(cb -> cb.setSelected(false));
            updateAdicionaisButtonVisibility();

            VBox initialScreen = createInitialScreen(primaryStage);
            primaryStage.getScene().setRoot(initialScreen);
        });

        HBox buttonsBox = new HBox(15);
        buttonsBox.setAlignment(Pos.CENTER);
        buttonsBox.getChildren().addAll(adicionaisButton, confirmButton, backButton);

        screen.getChildren().addAll(
                titleLabel,
                sorveteSection,
                picoleSection,
                summaryLabel,
                selectionSummary,
                totalPriceLabel,
                buttonsBox
        );

        return screen;
    }

    private TitledPane createFlavorSection(String title,
                                           Map<String, Double> prices,
                                           Map<String, CheckBox> checkBoxMap,
                                           boolean isSorvete) {
        VBox content = new VBox(10);
        content.setPadding(new Insets(10));
        content.setAlignment(Pos.TOP_LEFT);

        for (Map.Entry<String, Double> entry : prices.entrySet()) {
            String flavor = entry.getKey();
            Double price = entry.getValue();

            CheckBox checkBox = new CheckBox(flavor + " - R$ " + String.format("%.2f", price));
            checkBox.setStyle("-fx-font-size: 14px;");
            checkBoxMap.put(flavor, checkBox);

            checkBox.setOnAction(e -> {
                if (checkBox.isSelected()) {
                    totalPrice += price;
                    // Inicializa set de adicionais para esse sorvete se não existir
                    if (isSorvete) {
                        adicionaisSelecionadosPorSorvete.putIfAbsent(flavor, new HashSet<>());
                    }
                } else {
                    totalPrice -= price;
                    if (isSorvete) {
                        // Remove adicionais desse sorvete ao desmarcar
                        adicionaisSelecionadosPorSorvete.remove(flavor);
                    }
                }
                updateSelectionSummary();
                updateTotalPriceLabel();
                updateAdicionaisButtonVisibility();
            });

            content.getChildren().add(checkBox);
        }

        TitledPane section = new TitledPane(title, content);
        section.setExpanded(true);
        section.setStyle("-fx-font-size: 16px; -fx-text-fill: #FF69B4;");

        return section;
    }

    private void updateAdicionaisButtonVisibility() {
        boolean algumSorveteSelecionado = sorveteCheckBoxes.keySet().stream()
                .anyMatch(flavor -> sorveteCheckBoxes.get(flavor).isSelected());

        adicionaisButton.setDisable(!algumSorveteSelecionado);
    }

    private void openAdicionaisPopup() {
        Stage popupStage = new Stage();
        popupStage.setTitle("Escolha os Adicionais");

        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(15));
        vbox.setStyle("-fx-background-color: #FFFFFF;");

        Label infoLabel = new Label("Selecione os adicionais para cada sorvete:");
        infoLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));

        vbox.getChildren().add(infoLabel);

        ScrollPane scrollPane = new ScrollPane();
        VBox adicionaisContent = new VBox(10);
        adicionaisContent.setPadding(new Insets(10));
        adicionaisContent.setAlignment(Pos.TOP_LEFT);

        // Para cada sorvete selecionado, criar um grupo de checkboxes de adicionais
        for (String sorvete : sorveteCheckBoxes.keySet()) {
            if (!sorveteCheckBoxes.get(sorvete).isSelected()) continue;

            Label sorveteLabel = new Label("Adicionais para " + sorvete + ":");
            sorveteLabel.setFont(Font.font("Arial", FontWeight.BOLD, 13));
            sorveteLabel.setTextFill(Color.web("#FF69B4"));

            VBox adicionaisBox = new VBox(5);
            adicionaisBox.setPadding(new Insets(0,0,0,10));
            adicionaisBox.setAlignment(Pos.TOP_LEFT);

            Set<String> adicionaisSelecionados = adicionaisSelecionadosPorSorvete.getOrDefault(sorvete, new HashSet<>());

            for (String adicional : adicionaisPrecos.keySet()) {
                CheckBox cb = new CheckBox(adicional + " - R$ " + String.format("%.2f", adicionaisPrecos.get(adicional)));
                cb.setStyle("-fx-font-size: 13px;");

                // Define checkbox como selecionado se já está nos adicionais
                cb.setSelected(adicionaisSelecionados.contains(adicional));

                cb.setOnAction(ev -> {
                    if (cb.isSelected()) {
                        adicionaisSelecionados.add(adicional);
                        totalPrice += adicionaisPrecos.get(adicional);
                    } else {
                        adicionaisSelecionados.remove(adicional);
                        totalPrice -= adicionaisPrecos.get(adicional);
                    }
                    adicionaisSelecionadosPorSorvete.put(sorvete, adicionaisSelecionados);
                    updateSelectionSummary();
                    updateTotalPriceLabel();
                });

                adicionaisBox.getChildren().add(cb);
            }

            vbox.getChildren().addAll(sorveteLabel, adicionaisBox);
        }

        scrollPane.setContent(vbox);
        scrollPane.setFitToWidth(true);
        scrollPane.setPrefHeight(300);

        VBox root = new VBox(10);
        root.setPadding(new Insets(10));
        root.getChildren().addAll(scrollPane);

        Scene scene = new Scene(root, 350, 350);
        popupStage.setScene(scene);
        popupStage.show();
    }

    private void updateSelectionSummary() {
        StringBuilder resumo = new StringBuilder();

        // Sorvetes com adicionais formatados
        for (String sorvete : sorveteCheckBoxes.keySet()) {
            if (sorveteCheckBoxes.get(sorvete).isSelected()) {
                double precoSorvete = sorvetePrecos.get(sorvete);
                Set<String> adicionais = adicionaisSelecionadosPorSorvete.getOrDefault(sorvete, Collections.emptySet());

                String adicionaisTexto = "";
                if (!adicionais.isEmpty()) {
                    // Montar texto "Adicionais: A, B e C"
                    List<String> listaAdicionais = adicionais.stream()
                            .map(ad -> ad + " - R$ " + String.format("%.2f", adicionaisPrecos.get(ad)))
                            .collect(Collectors.toList());

                    if (listaAdicionais.size() == 1) {
                        adicionaisTexto = " | Adicionais: " + listaAdicionais.get(0);
                    } else {
                        String todosMenosUltimo = String.join(", ", listaAdicionais.subList(0, listaAdicionais.size() - 1));
                        String ultimo = listaAdicionais.get(listaAdicionais.size() - 1);
                        adicionaisTexto = " | Adicionais: " + todosMenosUltimo + " e " + ultimo;
                    }
                }

                double precoAdicionais = adicionais.stream()
                        .mapToDouble(ad -> adicionaisPrecos.get(ad))
                        .sum();

                double precoTotal = precoSorvete + precoAdicionais;

                resumo.append(String.format("Sorvete: %s - R$ %.2f%s | Total - R$ %.2f%n",
                        sorvete, precoSorvete, adicionaisTexto, precoTotal));
            }
        }

        // Picolés (sem adicionais)
        for (String picole : picoleCheckBoxes.keySet()) {
            if (picoleCheckBoxes.get(picole).isSelected()) {
                double precoPicole = picolePrecos.get(picole);
                resumo.append(String.format("Picolé: %s - R$ %.2f%n", picole, precoPicole));
            }
        }

        selectionSummary.setText(resumo.toString());
    }

    private void updateTotalPriceLabel() {
        totalPriceLabel.setText("Total: R$ " + String.format("%.2f", totalPrice));
    }

    private void styleButton(Button button) {
        button.setPrefWidth(150);
        button.setPrefHeight(40);
        button.setStyle(
                "-fx-background-color: #FF69B4; " +
                        "-fx-text-fill: white; " +
                        "-fx-font-size: 16px; " +
                        "-fx-background-radius: 5; " +
                        "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.2), 3, 0, 0, 2);"
        );

        button.setOnMouseEntered(e ->
                button.setStyle(
                        "-fx-background-color: #FF5CA8; " +
                                "-fx-text-fill: white; " +
                                "-fx-font-size: 16px; " +
                                "-fx-background-radius: 5; " +
                                "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.3), 5, 0, 0, 3);"
                )
        );

        button.setOnMouseExited(e ->
                button.setStyle(
                        "-fx-background-color: #FF69B4; " +
                                "-fx-text-fill: white; " +
                                "-fx-font-size: 16px; " +
                                "-fx-background-radius: 5; " +
                                "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.2), 3, 0, 0, 2);"
                )
        );
    }

    public static void main(String[] args) {
        launch(args);
    }
}