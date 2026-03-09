module school.coda.samuel_hong_zhong.bataille_navale {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.almasb.fxgl.all;
    requires java.desktop;

    opens school.coda.samuel_hong_zhong.bataille_navale to javafx.fxml;
    exports school.coda.samuel_hong_zhong.bataille_navale;
}