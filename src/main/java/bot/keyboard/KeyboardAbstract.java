package bot.keyboard;

import api.longpoll.bots.model.objects.additional.buttons.Button;

public abstract class KeyboardAbstract {
    protected static final Button.Color PRIMARY_COLOR = Button.Color.PRIMARY;
    protected final static String BOOK_PROCEDURE_TEXT = "Записаться на процедуру";
    protected final static String CHECK_MY_PROCEDURE_TEXT = "Когда я записан?";
    protected final static String PRICE_LIST_TEXT = "Какая стоимость?";
    protected final static String CANSEL_MY_PROCEDURE_TEXT = "Отменить запись";
    protected static final Button.Color POSITIVE_COLOR = Button.Color.POSITIVE;
    protected static final Button.Color NEGATIVE_COLOR = Button.Color.NEGATIVE;
    protected boolean isButtonPayload(String text) {
        return text.contains("{") && text.contains("}");
    }
}
