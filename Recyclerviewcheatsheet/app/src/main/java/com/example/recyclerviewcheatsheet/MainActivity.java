package com.example.recyclerviewcheatsheet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.recyclerviewcheatsheet.Adapter.MainAdapter;
import com.example.recyclerviewcheatsheet.Modal.Advertisement;
import com.example.recyclerviewcheatsheet.Modal.ChildBook;
import com.example.recyclerviewcheatsheet.Modal.OnCartImageClickListener;
import com.example.recyclerviewcheatsheet.Modal.OnWishListImageClickListener;
import com.example.recyclerviewcheatsheet.Modal.ParentBook;
import com.example.recyclerviewcheatsheet.ViewHolder.ChildViewHolder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

public class MainActivity extends AppCompatActivity implements OnWishListImageClickListener, OnCartImageClickListener {

    RecyclerView mRecyclerView;
    ArrayList<ParentBook> mParentBookList;
    ArrayList<ChildBook> mMysteryBooks;
    ArrayList<ChildBook> mRomanceBooks;
    ArrayList<ChildBook> mScienceFiction;
    ArrayList<ChildBook> mFantasyBooks;
    ArrayList<ChildBook> mNonFictionBooks;
    ArrayList<Advertisement> mAdvertisements;
    ArrayList<Object> mLists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("tag", "onCreate: helllllllloooooooo");
        Objects.requireNonNull(getSupportActionBar()).hide();

        mParentBookList = new ArrayList<>();
        mMysteryBooks = new ArrayList<>();
        mRomanceBooks = new ArrayList<>();
        mScienceFiction = new ArrayList<>();
        mFantasyBooks = new ArrayList<>();
        mNonFictionBooks = new ArrayList<>();
        mAdvertisements = new ArrayList<>();
        mLists = new ArrayList<>();

        mMysteryBooks.add(new ChildBook(R.drawable.the_adventure_of_sherlock,"The Adventures of Sherlock Holmes by Arthur Conan Doyle","300"));
        mMysteryBooks.add(new ChildBook(R.drawable.da_vinci_code,"The Da Vinci Code by Dan Brown","800"));
        mMysteryBooks.add(new ChildBook(R.drawable.gone_girl,"Gone Girl by Gillian Flynn","600"));
        mMysteryBooks.add(new ChildBook(R.drawable.umberto_eco_the_name_of_the_rose,"\"The Name of the Rose\" by Umberto Eco","700"));
        mMysteryBooks.add(new ChildBook(R.drawable.the_girl_with_dragon,"\"The Girl with the Dragon Tattoo\" by Stieg Larsson","545"));
        mMysteryBooks.add(new ChildBook(R.drawable.the_murder_of,"\"The Murder of Roger Ackroyd\" by Agatha Christie","725"));
        mMysteryBooks.add(new ChildBook(R.drawable.the_tower,"\"The Tower Treasure\" by Leslie McFarlane","825"));

        mRomanceBooks.add(new ChildBook(R.drawable.pride_and_prejudice,"\"Pride and Prejudice\" by Jane Austen","258"));
        mRomanceBooks.add(new ChildBook(R.drawable.wulthering_height,"\"Wuthering Heights\" by Emily Brontë","147"));
        mRomanceBooks.add(new ChildBook(R.drawable.sense_and_sensibility,"\"Sense and Sensibility\" by Jane Austen","565"));
        mRomanceBooks.add(new ChildBook(R.drawable.persuassion,"\"Persuasion\" by Jane Austen","156"));
        mRomanceBooks.add(new ChildBook(R.drawable.ema,"\"Emma\" by Jane Austen","754"));
        mRomanceBooks.add(new ChildBook(R.drawable.jane_eyre,"\"Jane Eyre\" by Charlotte Brontë","850"));
        mRomanceBooks.add(new ChildBook(R.drawable.love_in_the_time_of,"\"Love in the Time of Cholera\" by Gabriel García Márquez","895"));

        mScienceFiction.add(new ChildBook(R.drawable.dune,"\"Dune\" by Frank Herbert","756"));
        mScienceFiction.add(new ChildBook(R.drawable.the_war_worlds,"\"The War of the Worlds\" by H.G. Wells","999"));
        mScienceFiction.add(new ChildBook(R.drawable.douglas_adams,"\"The Hitchhiker's Guide to the Galaxy\" by Douglas Adams","1050"));
        mScienceFiction.add(new ChildBook(R.drawable.enders_game,"\"Ender's Game\" by Orson Scott Card","1070"));
        mScienceFiction.add(new ChildBook(R.drawable.the_martian_by,"\"The Martian\" by Andy Weir","750"));
        mScienceFiction.add(new ChildBook(R.drawable.the_time_machine,"\"The Time Machine\" by H.G. Wells","350"));
        mScienceFiction.add(new ChildBook(R.drawable.fahrenheit,"\"Fahrenheit 451\" by Ray Bradbury","764"));

        mFantasyBooks.add(new ChildBook(R.drawable.the_lord_of_rings,"\"The Lord of the Rings\" by J.R.R. Tolkien","350"));
        mFantasyBooks.add(new ChildBook(R.drawable.harry_porter,"\"Harry Potter and the Sorcerer's Stone\" by J.K. Rowling","1000"));
        mFantasyBooks.add(new ChildBook(R.drawable.the_chronicles_of,"\"The Chronicles of Narnia\" by C.S. Lewis","600"));
        mFantasyBooks.add(new ChildBook(R.drawable.the_wheel_of_time,"\"The Wheel of Time\" by Robert Jordan","1040"));
        mFantasyBooks.add(new ChildBook(R.drawable.the_dark_tower_,"\"The Dark Tower\" by Stephen King","999"));
        mFantasyBooks.add(new ChildBook(R.drawable.the_sword_of_shannara_by_terry_brooks,"\"The Sword of Shannara\" by Terry Brooks","389"));
        mFantasyBooks.add(new ChildBook(R.drawable.the_song_of_ice,"\"The Song of Ice and Fire\" by George R.R. Martin","888"));


        mNonFictionBooks.add(new ChildBook(R.drawable.the_alchemist,"\"The Alchemist\" by Paulo Coelho","599"));
        mNonFictionBooks.add(new ChildBook(R.drawable.the_seven_habits,"\"The 7 Habits of Highly Effective People\" by Stephen Covey","890"));
        mNonFictionBooks.add(new ChildBook(R.drawable.the_power_of_now,"\"The Power of Now\" by Eckhart Tolle","545"));
        mNonFictionBooks.add(new ChildBook(R.drawable.awaken_the_giant,"\"Awaken the Giant Within\" by Tony Robbins","754"));
        mNonFictionBooks.add(new ChildBook(R.drawable.the_four_hour_work,"\"The 4-Hour Work Week\" by Tim Ferriss","746"));
        mNonFictionBooks.add(new ChildBook(R.drawable.the_forty_eight_laws,"\"The 48 Laws of Power\" by Robert Greene","740"));
        mNonFictionBooks.add(new ChildBook(R.drawable.the_art_of_living,"\"The Art of Racing in the Rain\" by Garth Stein","148"));

        mParentBookList.add(new ParentBook("Mystery Books",mMysteryBooks));
        mParentBookList.add(new ParentBook("Romance Books",mRomanceBooks));
        mParentBookList.add(new ParentBook("Science Fiction Books",mScienceFiction));
        mParentBookList.add(new ParentBook("Fantasy Book",mFantasyBooks));
        mParentBookList.add(new ParentBook("Non-Fiction Books",mNonFictionBooks));

        mAdvertisements.add(new Advertisement(R.drawable.protein_x,"ProteinX","New Year, New You! Get 50% off on our fitness products with promo code NYNY50"));
        mAdvertisements.add(new Advertisement(R.drawable.spotify,"Spotify","Limited time offer: Get a free month of our premium subscription when you sign up today!"));
        mAdvertisements.add(new Advertisement(R.drawable.flipkart,"flipkart",
                "Huge sale on summer clothing – up to 70% off! Don't miss out on these deals."));

        mLists.addAll(mParentBookList);
        mLists.addAll(mAdvertisements);
        Collections.shuffle(mLists);

        mRecyclerView = findViewById(R.id.book_parent_rv);

        MainAdapter adapter = new MainAdapter(MainActivity.this,mLists);

//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,true);
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2,,GridLayoutManager.HORIZONTAL,false);
//        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
//            @Override
//            public int getSpanSize(int position) {
//                return (position % 2 == 0 ? 2 : 1);
//            }
//        });
        //StaggeredLayoutMananger
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    @Override
    public void OnCartImageClick(RecyclerView.ViewHolder holder, int position) {

                if(((ChildViewHolder) holder).cart_image.getDrawable().getConstantState()== getResources().getDrawable(R.drawable.add_to_cart_64).getConstantState()){
                    ((ChildViewHolder) holder).cart_image.setImageResource(R.drawable.check);
                    Toast.makeText(this, ((ChildViewHolder) holder).book_title.getText().toString() + " added to your cart successfully", Toast.LENGTH_SHORT).show();

                } else {
                    ((ChildViewHolder) holder).cart_image.setImageResource(R.drawable.add_to_cart_64);
                    Toast.makeText(this, ((ChildViewHolder) holder).book_title.getText().toString() + " removed from your cart", Toast.LENGTH_SHORT).show();

                }

    }

    @Override
    public void onWishlistImageClick(RecyclerView.ViewHolder holder, int position) {

               if(((ChildViewHolder)holder).wishlist_image.getDrawable().getConstantState()== getResources().getDrawable(R.drawable.add_to_wishlist_icon1).getConstantState()){
                    ((ChildViewHolder) holder).wishlist_image.setImageResource(R.drawable.wishlist_red);
                    Toast.makeText(this, ((ChildViewHolder) holder).book_title.getText().toString() + " added to wishlist", Toast.LENGTH_SHORT).show();

                } else {
                    ((ChildViewHolder) holder).wishlist_image.setImageResource(R.drawable.add_to_wishlist_icon1);
                    Toast.makeText(this, ((ChildViewHolder) holder).book_title.getText().toString() + " removed from wishlist", Toast.LENGTH_SHORT).show();
                }
    }
}