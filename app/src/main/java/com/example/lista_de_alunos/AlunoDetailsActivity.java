package com.example.lista_de_alunos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import models.Aluno;

public class AlunoDetailsActivity extends AppCompatActivity {

    TextView matricula;
    TextView nome;
    TextView curso;
    TextView ano;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aluno_details);

        Intent intent = getIntent();

        if (intent.hasExtra("selectedItem")) {
            Aluno alunoSelected = (Aluno) intent.getSerializableExtra("selectedItem");

            matricula = findViewById(R.id.matricula);
            nome = findViewById(R.id.nome);
            curso = findViewById(R.id.curso);
            ano = findViewById(R.id.ano);

            matricula.setText(String.format("Matrícula: %s", alunoSelected.getMatricula()));
            nome.setText(String.format("Nome Completo: %s %s", alunoSelected.getNome(), alunoSelected.getSobrenome()));
            curso.setText(String.format("Curso: %s", alunoSelected.getCurso()));
            ano.setText(String.format("Ano: %d", alunoSelected.getAno()));
        }
    }
}