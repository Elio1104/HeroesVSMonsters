module technofutur.heroesvsmonster {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;

    opens technofutur.heroesvsmonsters to javafx.fxml;
    exports technofutur.heroesvsmonsters;
    opens technofutur.heroesvsmonsters.menu to javafx.fxml;
    exports technofutur.heroesvsmonsters.menu;
    exports technofutur.heroesvsmonsters.menu.gameMenu;
    opens technofutur.heroesvsmonsters.menu.gameMenu to javafx.fxml;
}