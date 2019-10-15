package seedu.address.ui;

import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;
import seedu.address.autocomplete.AutoCompleteWord;
import seedu.address.autocomplete.AutoCompleteWordHandler;
import seedu.address.commons.core.LogsCenter;

import java.util.logging.Logger;

/**
 * Panel containing the list of suggested words.
 */
public class AutoCompletePanel extends UiPart<Region> {
    private static final Logger logger = LogsCenter.getLogger(AutoCompletePanel.class);
    private static final String FXML = "AutoCompletePanel.fxml";

    private AutoCompleteWordHandler autoCompleteWordHandler;

    @FXML
    private ListView<AutoCompleteWord> autoCompleteWordListView;

    public AutoCompletePanel(AutoCompleteWordHandler autoCompleteWordHandler) {
        super(FXML);
        this.autoCompleteWordHandler = autoCompleteWordHandler;
        autoCompleteWordListView.setItems(autoCompleteWordHandler.getOListAutoCompleteWords());
        autoCompleteWordListView.setCellFactory(listView -> new AutoCompleteListViewCell());
    }

    /**
     * Custom {@code ListCell} that displays the graphics of a {@code AutoCompleteWord} using a {@code AutoCompleteCard}
     */
    class AutoCompleteListViewCell extends ListCell<AutoCompleteWord> {
        @Override
        protected void updateItem(AutoCompleteWord autoCompleteWord, boolean empty) {
            super.updateItem(autoCompleteWord, empty);

            if (empty || autoCompleteWord == null) {
                setGraphic(null);
                setText(null);
            } else {
                setGraphic(new AutoCompleteCard(autoCompleteWord).getRoot());
            }
        }
    }

    public AutoCompleteWord getSelected() {
        return autoCompleteWordListView.getSelectionModel().getSelectedItem();
    }

    public void select(int index) {
        autoCompleteWordListView.getSelectionModel().select(index);
    }

    public int getTotalItems() {
        return autoCompleteWordListView.getItems().size();
    }

    public void updateListView(String currentPhraseInCommandBox) {
        logger.info("Updated list");
        autoCompleteWordHandler.updateList(currentPhraseInCommandBox);
    }
}
