package org.example.zzpwjplugin;

import com.intellij.ide.BrowserUtil;
import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.ui.Gray;
import com.intellij.ui.JBColor;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;

public class CustomDialog extends DialogWrapper {
    JEditorPane pane;

    public CustomDialog() {
        super(true); // use current window as parent
        init();
        setTitle("Search Box");
        setSize(200, 50);
        setOKButtonText("Browse");
    }

    @Override
    protected void doOKAction() {
        super.doOKAction();
        BrowserUtil.browse("https://google.pl/search?q=" + pane.getText());
    }

    @Nullable
    @Override
    protected JComponent createCenterPanel() {
        JPanel dialogPanel = new JPanel(new BorderLayout());

        JLabel label = new JLabel("testing");
        pane = new JEditorPane();
        pane.setPreferredSize(new Dimension(100, 20));
        pane.setCaretColor(JBColor.GREEN);
        pane.setBackground(new JBColor(Gray._80, Gray._80));
        pane.setFont(new Font("Calibri", Font.PLAIN, 14));

        label.setPreferredSize(new Dimension(100, 100));
        dialogPanel.add(label, BorderLayout.CENTER);
        dialogPanel.add(pane, BorderLayout.CENTER);
        return dialogPanel;
    }
}
