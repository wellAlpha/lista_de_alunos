package com.example.lista_de_alunos.modelView;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.lista_de_alunos.model.Aluno;

import java.util.ArrayList;
import java.util.List;

public class AlunoModelView extends ViewModel {
    private MutableLiveData<List<Aluno>> alunosLiveData;

    public LiveData<List<Aluno>> getAlunosLiveData() {
        if (alunosLiveData == null) {
            alunosLiveData = new MutableLiveData<>();
            carregarAlunos();
        }
        return alunosLiveData;
    }

    public void addAlunoLiveData(Aluno novoAluno) {
        List<Aluno> listaAlunos = alunosLiveData.getValue();

        if(listaAlunos == null){
            listaAlunos = new ArrayList<>();
        }

        listaAlunos.add(novoAluno);
        alunosLiveData.setValue(listaAlunos);
    }

    private void carregarAlunos() {
        List<Aluno> alunos = new ArrayList<>();

        alunosLiveData.setValue(alunos);
    }
}
