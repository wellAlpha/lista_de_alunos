package com.example.lista_de_alunos.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.lista_de_alunos.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import com.example.lista_de_alunos.models.Aluno;

public class AlunoListActivity extends AppCompatActivity {
    private ListView listView;
    private FloatingActionButton floatBtn;
    private List<Aluno> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        items.add(new Aluno("João", "Silva", "123", "01/01/1990", "Análise e Desenvolvimento de Sistemas", 2021));
        items.add(new Aluno("Maria", "Silva","456", "02/02/1991", "Administração", 2021));
        items.add(new Aluno("Pedro", "Silva", "789", "03/03/1992", "Análise e Desenvolvimento de Sistemas", 2021));
        items.add(new Aluno("João", "Silva", "123", "01/01/1990", "Análise e Desenvolvimento de Sistemas", 2021));
        items.add(new Aluno("Maria", "Silva","456", "02/02/1991", "Administração", 2021));
        items.add(new Aluno("Pedro", "Silva", "789", "03/03/1992", "Análise e Desenvolvimento de Sistemas", 2021));
        items.add(new Aluno("João", "Silva", "123", "01/01/1990", "Análise e Desenvolvimento de Sistemas", 2021));
        items.add(new Aluno("Maria", "Silva","456", "02/02/1991", "Administração", 2021));
        items.add(new Aluno("Pedro", "Silva", "789", "03/03/1992", "Análise e Desenvolvimento de Sistemas", 2021));
        items.add(new Aluno("João", "Silva", "123", "01/01/1990", "Análise e Desenvolvimento de Sistemas", 2021));
        items.add(new Aluno("Maria", "Silva","456", "02/02/1991", "Administração", 2021));
        items.add(new Aluno("Pedro", "Silva", "789", "03/03/1992", "Análise e Desenvolvimento de Sistemas", 2021));
        items.add(new Aluno("João", "Silva", "123", "01/01/1990", "Análise e Desenvolvimento de Sistemas", 2021));
        items.add(new Aluno("Maria", "Silva","456", "02/02/1991", "Administração", 2021));
        items.add(new Aluno("Pedro", "Silva", "789", "03/03/1992", "Análise e Desenvolvimento de Sistemas", 2021));
        items.add(new Aluno("João", "Silva", "123", "01/01/1990", "Análise e Desenvolvimento de Sistemas", 2021));
        items.add(new Aluno("Maria", "Silva","456", "02/02/1991", "Administração", 2021));
        items.add(new Aluno("Pedro", "Silva", "789", "03/03/1992", "Análise e Desenvolvimento de Sistemas", 2021));
        items.add(new Aluno("João", "Silva", "123", "01/01/1990", "Análise e Desenvolvimento de Sistemas", 2021));
        items.add(new Aluno("Maria", "Silva","456", "02/02/1991", "Administração", 2021));
        items.add(new Aluno("Pedro", "Silva", "789", "03/03/1992", "Análise e Desenvolvimento de Sistemas", 2021));

        listView = findViewById(R.id.list);
        floatBtn = findViewById(R.id.floatingActionButton);

        ArrayAdapter<Aluno> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Aluno selectedItem = adapter.getItem(position);

                Intent intent = new Intent(AlunoListActivity.this, AlunoDetailsActivity.class);

                intent.putExtra("selectedItem", selectedItem);

                startActivity(intent);
                // Toast.makeText(MainActivity.this, "Item selecionado: " + selectedItem, Toast.LENGTH_SHORT).show();
            }
        });

        floatBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AlunoListActivity.this, AlunoCreateActivity.class);

                startActivity(intent);
            }
        });
    }
}