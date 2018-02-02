package com.example.adiosesr.androidtraining;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import com.example.adiosesr.androidtraining.models.Autor;
import com.example.adiosesr.androidtraining.models.Book;
import java.util.ArrayList;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btnBook)
    Button btnBook;

    @BindView(R.id.btnList)
    Button btnList;

    BookFragment bookFragment = new BookFragment();
    BookListFragment bookListFragment = new BookListFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Book book = buildBook();
        arrayBook(book);
        getDataName();

        Bundle bundle = new Bundle();

        bundle.putSerializable("books",book);
        bundle.putString("nameFrag", getDataName());
        bundle.putSerializable("listBook",arrayBook(book));

        bookListFragment.setArguments(bundle);
        bookFragment.setArguments(bundle);

    }

    private String getDataName() {
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String dataName = null;
        if (extras != null) {
            dataName = extras.getString("name");
        }
        return dataName;
    }


    private ArrayList arrayBook(Book book) {
        ArrayList<Book> listBook = new ArrayList<>();
        listBook.add(book);
        listBook.add(book);
        listBook.add(book);
        listBook.add(book);
        listBook.add(book);

        return  listBook;
    }

    @OnClick(R.id.btnBook)
    public void frameBook()
    {
        FragmentTransaction frag = getSupportFragmentManager().beginTransaction();
        frag.replace(R.id.fragmentBook,bookFragment);
        frag.commit();
    }

    @OnClick(R.id.btnList)
    public void frameList()
    {
        FragmentTransaction frag = getSupportFragmentManager().beginTransaction();
        frag.replace(R.id.fragmentBook,bookListFragment);
        frag.commit();
    }

    private Book buildBook() {
        Book b = new Book();
        b.setId(233);
        b.setName("Java in Android");
        b.setPages(520);
        b.setAutor(buildAutor());
        return  b;
    }

    private Autor buildAutor() {
        Autor a = new Autor();
        a.setFirstName("Arthur");
        a.setLastName("Dioses");

        return a;
    }


}