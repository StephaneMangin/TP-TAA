import org.istic.taa.domain.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class JpaTest {

    private EntityManager manager;

    public JpaTest(EntityManager manager) {
        this.manager = manager;
    }


    private void createObjects() {
        int numOfUser = manager.createQuery("Select a From User a", User.class).getResultList().size();
        if (numOfUser == 0) {

            Team team = new Team("Diverse");
            Sprint sprint = new Sprint(team, "OpenCompare Spin Off", LocalDateTime.now(), LocalDateTime.now().plusYears(1));

            Set<User> users = new HashSet<User>();
            users.add(new User("Benoit", "Baudry", Usertype.Manager));
            users.add(new User("Mathieu", "Asher", Usertype.ResearchProfessor));
            users.add(new User("Guillaume", "Bécan", Usertype.PhdStudent));
            users.add(new User("Stéphane", "Mangin", Usertype.Intern));
            users.add(new User("Hugo", "Vallée", Usertype.Intern));
            team.setUsers(users);

            Set<Task> tasks = new HashSet<Task>();
            tasks.add(new Task("0.5 release", Tasktype.EPICS, LocalDateTime.now(), LocalDateTime.now().plusMonths(3), ""));
            tasks.add(new Task("Graphical design", Tasktype.EPICS, LocalDateTime.now().plusMonths(2), LocalDateTime.now().plusMonths(5), ""));
            sprint.setTasks(tasks);

            team.setSprint(sprint);

            manager.persist(team);
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("mysql");
        EntityManager manager = factory.createEntityManager();

        EntityTransaction tx = manager.getTransaction();
        JpaTest main = new JpaTest(manager);
        tx.begin();
        try {
            main.createObjects();

        } catch (Exception e) {
            e.printStackTrace();
        }
        tx.commit();
        manager.close();
        factory.close();
    }

}
