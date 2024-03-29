package bot.keyboard;

import api.longpoll.bots.model.objects.additional.Keyboard;
import api.longpoll.bots.model.objects.additional.buttons.Button;

public abstract class KeyboardAbstract {
    protected final static Button.Color PRIMARY_COLOR = Button.Color.PRIMARY;
    protected final static String BOOK_PROCEDURE_TEXT = "Записаться на процедуру";
    protected final static String CHECK_MY_PROCEDURE_TEXT = "Когда я записан?";
    protected final static String PRICE_LIST_TEXT = "Какая стоимость?";
    protected final static String CANSEL_MY_PROCEDURE_TEXT = "Отменить запись";
    protected final static String EXAMPLE_WORK = "Примеры наших работ";
    protected final static Button.Color POSITIVE_COLOR = Button.Color.POSITIVE;
    protected final static Button.Color NEGATIVE_COLOR = Button.Color.NEGATIVE;

    public abstract Keyboard generateKeyboard();

}
