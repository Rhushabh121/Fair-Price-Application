package comp3350.fairprice.presentation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import comp3350.fairprice.objects.Post;
import comp3350.fairprice.R;

import java.util.ArrayList;
import java.util.List;

//This class is used for maintaining the list items
public class ListAdapter extends ArrayAdapter<Post> {

    public ListAdapter(Context context, List<Post> postList) {
        super(context, R.layout.post_list_item, postList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Post post = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.post_list_item, parent, false);

        }

        TextView postTitle = convertView.findViewById(R.id.post_title);
        TextView postPrice = convertView.findViewById(R.id.post_price);

        postTitle.setText(post.getTitle());
        postPrice.setText(post.getPrice());

        return convertView;
    }
}
