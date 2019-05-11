package com.geniusplaza.app.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.geniusplaza.app.R;
import com.geniusplaza.app.data.remote.model.User;
import com.geniusplaza.app.utils.ColorUtil;
import com.geniusplaza.app.utils.GlideTools;
import com.geniusplaza.app.utils.ItemAnimation;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UsersAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private ArrayList<User> items;
    private UsersInterface usersInterface;

    public void setUsersInterface(UsersInterface usersInterface) {
        this.usersInterface = usersInterface;
    }

    public UsersAdapter() {
        this.items = new ArrayList<>();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new UserViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_user, parent, false));
    }


    private void inflateUserView(RecyclerView.ViewHolder holder, int position) {
        User user = items.get(holder.getAdapterPosition());
        UserViewHolder userViewHolder = (UserViewHolder) holder;
        String userName = user.getFirstName() + " " + user.getLastName();
        userViewHolder.userNameTV.setText(userName);
        userViewHolder.emailTV.setText(user.getEmail());
        userViewHolder.imageLetterTV.setText(user.getFirstName().substring(0, 1));
        displayImage(userViewHolder, user);
        userViewHolder.itemView.setOnClickListener(view -> usersInterface.onUserClick(user, position));
        userViewHolder.itemView.setOnLongClickListener(view -> {
            usersInterface.onUserLongPress(user, position);
            return true;
        });
    }

    private void displayImage(UserViewHolder holder, User user) {
        if (user.getAvatar() != null && !user.getAvatar().isEmpty()) {
            GlideTools.displayImageRound(holder.emailTV.getContext(), holder.imageV, user.getAvatar());
            holder.imageLetterTV.setVisibility(View.GONE);
        } else {
            holder.imageV.setImageResource(R.drawable.shape_circle);
            holder.imageV.setColorFilter(ColorUtil.getMatColor(holder.emailTV.getContext(), "500"));
            holder.imageLetterTV.setVisibility(View.VISIBLE);
        }
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        inflateUserView(holder, position);
        setAnimation(holder.itemView, position);

    }

    private int lastPosition = -1;
    private boolean on_attach = true;

    private void setAnimation(View view, int position) {
        if (position > lastPosition) {
            ItemAnimation.animate(view, on_attach ? position : -1, ItemAnimation.FADE_IN);
            lastPosition = position;
        }
    }

    public void addAll(List<User> users) {
        items.addAll(users);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public interface UsersInterface {
        void onUserClick(User user, int position);

        void onUserLongPress(User user, int position);

    }

    class UserViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.image)
        ImageView imageV;

        @BindView(R.id.image_letter)
        TextView imageLetterTV;

        @BindView(R.id.userNameTV)
        TextView userNameTV;

        @BindView(R.id.emailTV)
        TextView emailTV;

        public UserViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
