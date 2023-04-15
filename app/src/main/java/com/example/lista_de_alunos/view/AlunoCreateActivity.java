package com.example.lista_de_alunos.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lista_de_alunos.R;
import com.example.lista_de_alunos.model.Aluno;

import java.util.Random;

public class AlunoCreateActivity extends AppCompatActivity {
    EditText nome;
    EditText sobrenome;
    EditText curso;
    EditText ano;
    Button createBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aluno_create);

        nome = findViewById(R.id.newNome);
        sobrenome = findViewById(R.id.newSobrenome);
        curso = findViewById(R.id.newCurso);
        ano = findViewById(R.id.newAno);
        createBtn = findViewById(R.id.createButton);

       createBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               if (validateForm()) {
                   criarAluno();
                   return;
               }
               Toast.makeText(AlunoCreateActivity.this, "Digite os campos de forma correta.", Toast.LENGTH_SHORT).show();
           }
       });
    }
    private void criarAluno() {
        Random random = new Random();
        int numero = random.nextInt(900) + 100;

        String nome = this.nome.getText().toString().trim();
        String sobrenome = this.sobrenome.getText().toString().trim();
        String curso = this.curso.getText().toString().trim();
        String ano = this.ano.getText().toString().trim();

        Intent result = new Intent();

        result.putExtra("Aluno", new Aluno(nome, sobrenome, String.valueOf(numero), curso, Integer.parseInt(ano)));

        Toast.makeText(AlunoCreateActivity.this, "Aluno cadastrado com sucesso.", Toast.LENGTH_SHORT).show();
        setResult(RESULT_OK, result);
        finish();
    }
    private boolean validateForm() {
        boolean isValid = true;
        if (!validateNome()) {
            isValid = false;
        }
        if (!validateSobrenome()) {
            isValid = false;
        }
        if (!validateCurso()) {
            isValid = false;
        }
        if (!validateAno()) {
            isValid = false;
        }
        return isValid;
    }
    protected boolean validateNome (){
        if (TextUtils.isEmpty(nome.getText())) {
            nome.setError("Este campo é obrigatório");
            return false;
        }
        return true;
    }
    protected boolean validateSobrenome (){
        if (TextUtils.isEmpty(sobrenome.getText())) {
            sobrenome.setError("Este campo é obrigatório");
            return false;
        }
        return true;
    }
    protected boolean validateCurso (){
        if (TextUtils.isEmpty(curso.getText())) {
            curso.setError("Este campo é obrigatório");
            return false;
        }
        return true;
    }
    protected boolean validateAno (){
        if (TextUtils.isEmpty(ano.getText())) {
            ano.setError("Este campo é obrigatório");
            return false;
        }
        return true;
    }
}