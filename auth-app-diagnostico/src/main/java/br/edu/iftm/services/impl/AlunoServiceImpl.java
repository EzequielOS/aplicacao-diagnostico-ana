package br.edu.iftm.services.impl;

import br.edu.iftm.models.Aluno;
import br.edu.iftm.repositories.AlunoRepository;
import br.edu.iftm.services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class AlunoServiceImpl implements AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Override
    public Aluno save(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    @Override
    public Aluno findById(String id) {
        return alunoRepository.findById(id).orElse(null);
    }

    @Override
    public List<Aluno> findAll() {
        return alunoRepository.findAll();
    }

    @Override
    public void deleteById(String id) {
        alunoRepository.deleteById(id);
    }


    private String calculateClass(String birthDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate birthDateParsed = LocalDate.parse(birthDate, formatter);
        int currentYear = LocalDate.now().getYear();

        int yearTurningSix = birthDateParsed.getYear() + 6;
        LocalDate cutOffDate = LocalDate.of(yearTurningSix, 3, 31);

        int entryYear;
        if (!birthDateParsed.isAfter(cutOffDate)) {
            entryYear = yearTurningSix;
        } else {
            entryYear = yearTurningSix + 1;
        }

        int classYear = 1 + (currentYear - entryYear);

        if (classYear < 1) {
            classYear = 1;
        } else if (classYear > 4) {
            classYear = 4;
        }

        return classYear + "º Ano";
    }

    public Aluno registerStudent(String name, String birthDate, String parentId) {
        if (parentId == null || parentId.isEmpty()) {
            throw new IllegalArgumentException("O aluno precisa estar vinculado a um responsável.");
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate birthDateParsed = LocalDate.parse(birthDate, formatter);
        int age = LocalDate.now().getYear() - birthDateParsed.getYear();

        if (age < 5 || age > 12) {
            throw new IllegalArgumentException("A idade permitida para cadastro é entre 5 e 12 anos.");
        }

        String className = calculateClass(birthDate);

        Aluno student = new Aluno();
        student.setName(name);
        student.setBirthDate(birthDate);
        student.setClassName(className);
        student.setScore(null);
        student.setParentId(parentId);

        return alunoRepository.save(student);
    }

    public List<Aluno> getStudentsByParent(String parentId) {
        return alunoRepository.findByParentId(parentId);
    }
}