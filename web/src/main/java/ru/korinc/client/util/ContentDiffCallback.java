package ru.korinc.client.util;

import java.util.List;

import ru.korinc.core.modules.player.Content;

/**
 * Created by gputintsev on 07.03.2018.
 */

public class ContentDiffCallback extends DiffUtil.Callback {

    private List<Content> oldList;

    private List<Content> newList;

    public ContentDiffCallback(List<Content> oldList, List<Content> newList) {
        this.oldList = oldList;
        this.newList = newList;
    }

    @Override
    public int getOldListSize() {
        return oldList.size();
    }

    @Override
    public int getNewListSize() {
        return newList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return oldList.get(oldItemPosition).getOriginalId()
                .equals(newList.get(newItemPosition).getOriginalId());
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return oldList.get(oldItemPosition).getOriginalId()
                .equals(newList.get(newItemPosition).getOriginalId());
    }
}
