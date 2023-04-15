package com.example.lista_de_alunos.view;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.lista_de_alunos.R;
import com.example.lista_de_alunos.modelView.AlunoModelView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import com.example.lista_de_alunos.model.Aluno;

public class AlunoListActivity extends AppCompatActivity {
    private ListView listView;
    private FloatingActionButton floatBtn;
    // private List<Aluno> items = new ArrayList<>();
    private AlunoModelView alunoViewModel;

    private ArrayAdapter<Aluno> adapter;

    private ActivityResultLauncher<Intent> criarAlunoLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alunoViewModel = new ViewModelProvider(this).get(AlunoModelView.class);

        listView = findViewById(R.id.list);
        floatBtn = findViewById(R.id.floatingActionButton);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);

        alunoViewModel.getAlunosLiveData().observe(this, new Observer<List<Aluno>>() {
            @Override
            public void onChanged(List<Aluno> alunos) {
                adapter.clear();
                adapter.addAll(alunos);
            }
        });

        listView.setAdapter(adapter);

        criarAlunoLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK) {
                        Aluno novoAluno = (Aluno) result.getData().getSerializableExtra("Aluno");

                        alunoViewModel.addAlunoLiveData(novoAluno);
                    }
                });
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

                criarAlunoLauncher.launch(intent);
            }
        });
    }


}