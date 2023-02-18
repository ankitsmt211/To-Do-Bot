package org.alphabee.todo;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.alphabee.todo.commands.AddListner;
import org.alphabee.todo.config.Config;

public class Application {
    public static void main(String[] args) {
        JDA jda = JDABuilder
                .createDefault(Config.token)
                .enableIntents(GatewayIntent.MESSAGE_CONTENT)
                .build();
        jda.addEventListener(new AddListner());
    }
}