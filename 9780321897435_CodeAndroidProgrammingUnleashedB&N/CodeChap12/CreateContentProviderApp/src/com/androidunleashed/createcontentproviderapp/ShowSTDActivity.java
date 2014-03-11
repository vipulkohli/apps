package com.androidunleashed.createcontentproviderapp;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.SimpleCursorAdapter;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.widget.ListView;
import android.content.Intent;
import android.net.Uri;
import android.view.View;

public class ShowSTDActivity extends ListActivity implements LoaderCallbacks<Cursor> {
    private SimpleCursorAdapter adapter;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {    
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showstd);  
        String[] columns = new String[] { CountriesProvider.COUNTRY};  
        int[] toIds = new int[] {android.R.id.text1};  
        getLoaderManager().initLoader(0, null,this);
        adapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_1, null, columns, toIds, 0);
        setListAdapter(adapter);
    }    
    
    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        String[] projection = new String[] {CountriesProvider.ID, CountriesProvider.COUNTRY, CountriesProvider.STDCODE} ;  
        CursorLoader cursorLoader = new CursorLoader(this, CountriesProvider.CONTENT_URI, projection, null, null, null);  
        return cursorLoader;
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        adapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        adapter.swapCursor(null);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Intent intent = new Intent(this, MaintainSTDActivity.class);
        Uri uri = Uri.parse(CountriesProvider.CONTENT_URI + "/" + id);
        intent.putExtra(CountriesProvider.CONTENT_ITEM_TYPE, uri);
        startActivity(intent);
    }
}
