import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.exceptions.VkApiException;
import api.longpoll.bots.methods.impl.messages.Send;
import api.longpoll.bots.model.events.messages.MessageNew;
import api.longpoll.bots.model.objects.additional.Keyboard;
import api.longpoll.bots.model.objects.additional.buttons.Button;
import api.longpoll.bots.model.objects.additional.buttons.TextButton;
import api.longpoll.bots.model.objects.basic.Message;
import com.google.gson.JsonObject;

import java.sql.Array;
import java.util.*;


public class VkBot extends LongPollBot {
    private static final String CLIENT_SECRET = "vk1.a.qngXzG8GuSy5b_0-R73DVfxky4Tfise_-hi5wTWp4QHp_urBB1wIcJE_1SkcrQQ55ffnkEoY7POLB8jsjqRRc7gHwUaAGzjvaiMey6C8-oycCveHgW5Ld6DRtB4y7U6GJdYvP0f0ZVCHKlfLkAgC3KkhyoG1Q9_78WbNbCUo-bBKYjnSHblcxVBt1JcL4ywVoR-rb5ssipxJEiINSAXv-Q";
    private static int PEER_ID;

    //Переменная которая хранит пермишенс у юзера на отправку
    private Map<Integer, Boolean> permissions = new HashMap<>();

    @Override
    public String getAccessToken() {
        return CLIENT_SECRET;
    }

    @Override
    public void onMessageNew(MessageNew messageNew) {
        Message message = messageNew.getMessage();
        PEER_ID = message.getPeerId();
            String welcomeMessageTruePerm = "Добро пожаловать в студию красоты SlyFox! 🌟\n" +
                    "Я готов помочь вам стать ещё красивее! 💅\n" +
                    "Пожалуйста, выберете соотвествующий пункт меню!";
            try {
                vk.messages.send()
                        .setPeerId(message.getPeerId())
                        .setMessage(welcomeMessageTruePerm)
                        .setKeyboard(createKeyboardWelcomeMenu())
                        .execute();

            } catch (VkApiException e) {
                throw new RuntimeException(e);
            }
    }


    private Keyboard createKeyboardWelcomeMenu() {
        JsonObject payload = new JsonObject();
        payload.addProperty("selectOptions", "bookProcedure");
        Button bookProcedure = new TextButton(Button.Color.POSITIVE, new TextButton.Action("Записаться на процедуру", payload));

        payload = new JsonObject();
        payload.addProperty("selectMenu", "checkMyProcedure");
        Button checkMyProcedure = new TextButton(Button.Color.PRIMARY, new TextButton.Action("Когда я записан?", payload));

        payload = new JsonObject();
        payload.addProperty("selectMenu", "canselMyProcedure");
        Button canselMyProcedure = new TextButton(Button.Color.NEGATIVE, new TextButton.Action("Отменить запись", payload));

        payload = new JsonObject();
        payload.addProperty("selectMenu", "checkPromotions");
        Button checkPromotions = new TextButton(Button.Color.SECONDARY, new TextButton.Action("Узнать об акциях", payload));

        List<List<Button>> buttonMenu = Arrays.asList(Arrays.asList(bookProcedure, checkMyProcedure),
                Arrays.asList(canselMyProcedure, checkPromotions));

        return new Keyboard(buttonMenu).setInline(true);
    }


}
