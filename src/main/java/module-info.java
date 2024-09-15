module com.wms.pos {
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

    opens com.wms.pos to javafx.fxml;
    exports com.wms.pos;
    exports com.wms.pos.controllers;
    opens com.wms.pos.controllers to javafx.fxml;
}