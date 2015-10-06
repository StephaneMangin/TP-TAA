package org.istic.taa;

import org.istic.taa.domain.*;
import org.junit.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import static junit.framework.Assert.assertEquals;

public class creationTest {

    private EntityManagerFactory factory;
    private EntityManager manager;
    private EntityTransaction tx;

    @Before
    public void setUp() throws Exception {
        factory = Persistence.createEntityManagerFactory("dev");
        manager = factory.createEntityManager();
        tx = manager.getTransaction();
        tx.begin();
        createObjects();
    }

    @After
    public void tearDown() throws Exception {
        tx.commit();
        manager.close();
        factory.close();
    }

    private void createObjects() {
        Team team = new Team("Diverse");
        manager.persist(team);
        Sprint sprint = new Sprint(team, "OpenCompare Spin Off", LocalDateTime.now(), LocalDateTime.now().plusYears(1));
        manager.persist(sprint);

        Set<User> users = new HashSet<User>();
        users.add(new User("Benoit", "Baudry", Usertype.Manager));
        users.add(new User("Mathieu", "Asher", Usertype.ResearchProfessor));
        users.add(new User("Guillaume", "Bécan", Usertype.PhdStudent));
        users.add(new User("Stéphane", "Mangin", Usertype.Intern));
        users.add(new User("Hugo", "Vallée", Usertype.Intern));
        for (User user: users) {
            manager.persist(user);
        }
        team.setUsers(users);

        Set<Task> tasks = new HashSet<Task>();
        tasks.add(new Task("0.5 release", Tasktype.EPICS, LocalDateTime.now(), LocalDateTime.now().plusMonths(3), ""));
        tasks.add(new Task("Graphical design", Tasktype.EPICS, LocalDateTime.now().plusMonths(2), LocalDateTime.now().plusMonths(5), ""));
        for (Task task: tasks) {
            manager.persist(task);
        }
        sprint.setTasks(tasks);
        team.setSprint(sprint);
    }

    @Test
    public void teamTest() {
        int numOfTeam = manager.createQuery("Select a From Team a", Team.class).getResultList().size();
        assertEquals(1, numOfTeam);
    }

    @Test
    public void taskTest() {
        int numOfTask = manager.createQuery("Select a From Task a", Task.class).getResultList().size();
        assertEquals(2, numOfTask);
    }

    @Test
    public void sprintTest() {
        int numOfSprint = manager.createQuery("Select a From Sprint a", Sprint.class).getResultList().size();
        assertEquals(1, numOfSprint);
    }

    @Test
    public void userTest() {
        int numOfUser = manager.createQuery("Select a From User a", User.class).getResultList().size();
        assertEquals(5, numOfUser);
    }

}
