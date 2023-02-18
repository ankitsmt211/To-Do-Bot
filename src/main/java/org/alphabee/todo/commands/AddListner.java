package org.alphabee.todo.commands;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.ArrayList;
import java.util.List;

public class AddListner extends ListenerAdapter {

    private List<String> todoList = new ArrayList<>();

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        super.onMessageReceived(event);
        if(event.getMessage().getContentRaw().startsWith("!add")){
            String command = event.getMessage().getContentRaw();
            String todo = command.substring(5);
            todoList.add(todo);
            event.getChannel().sendMessage("added to todoList").queue();
        }

        else if(event.getMessage().getContentRaw().startsWith("!show")){
            event.getChannel().sendMessage("List of to-do's").queue();
            for(String item: todoList){
                event.getChannel().sendMessage(item).queue();
            }
        }
    }


}
