module com.bsrshard.org.bsrshardorggui {
    requires javafx.controls;
    requires javafx.fxml;
    requires tess4j;
    requires java.desktop;
    requires java.compiler;


    opens com.bsrshard.org.bsrshardorggui to javafx.fxml;
    //exports com.bsrshard.org.bsrshardorggui;
    exports com.bsrshard.org.bsrshardorggui.views;
    opens com.bsrshard.org.bsrshardorggui.views to javafx.fxml;
    exports com.bsrshard.org.bsrshardorggui.controllers;
    opens com.bsrshard.org.bsrshardorggui.controllers to javafx.fxml;
}