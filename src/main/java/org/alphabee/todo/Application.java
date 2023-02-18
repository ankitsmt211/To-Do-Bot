package org.alphabee.todo;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import org.alphabee.todo.commands.Action;
import org.alphabee.todo.commands.Response;
import org.alphabee.todo.config.Bot;
import org.alphabee.todo.constants.Constants;

import static org.alphabee.todo.constants.Constants.todoList;

public class Application {
    public static void main(String[] args) {
        JDA jda = JDABuilder
                .createDefault(Bot.token)
                .build();
        jda.addEventListener(new Action());
        jda.addEventListener(new Response());
        Constants.displayList(todoList);
    }
}