package org.alphabee.todo.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.util.Date;

import static org.alphabee.todo.constants.Constants.displayList;
import static org.alphabee.todo.constants.Constants.todoList;

public class Response extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent messageReceivedEvent){
        EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.setTitle("To-Do List");
        embedBuilder.setColor(Color.CYAN);
        embedBuilder.setFooter(new Date().toInstant().toString());
        embedBuilder.setAuthor(messageReceivedEvent.getAuthor().getName());
        embedBuilder.setDescription(displayList(todoList));

        if( messageReceivedEvent.getMessage().getContentRaw().equals("!show")) {
            messageReceivedEvent.getChannel().sendMessageEmbeds(embedBuilder.build()).queue();
        }
    }
}
