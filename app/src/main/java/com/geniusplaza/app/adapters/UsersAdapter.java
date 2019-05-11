package com.geniusplaza.app.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.geniusplaza.app.R;
import com.geniusplaza.app.data.remote.model.User;
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
        this.items = new ArrayList<User>();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new HeadingViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_user, parent, false));
    }


    private void inflateUserView(RecyclerView.ViewHolder holder, int position) {
        User user = items.get(holder.getAdapterPosition());
        UserViewHolder userViewHolder = (UserViewHolder) holder;
        userViewHolder.titleTV.setText(user.getFirstName() + " " + user.getLastName());
        userViewHolder.iconCIV.setIconName(user.getIconName());
        userViewHolder.parentLayout.setOnClickListener(view -> {
            coachInterface.onCoachCategoryHeadingClick(user.getTitle(), position);
        });
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        inflateUserView(holder, position);
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

        @BindView(R.id.imageV)
        ImageView imageV;

        @BindView(R.id.titleTV)
        TextView titleTV;

        @BindView(R.id.parentLayout)
        RelativeLayout parentLayout;

        @BindView(R.id.descriptionTV)
        TextView descriptionTV;

        public UserViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
