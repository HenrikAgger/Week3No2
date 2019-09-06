package moviefacade;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class MovieFacade {
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    public MovieFacade(){}
    
    public Movie findByID(long id){
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Movie> query = 
                    em.createQuery("Select m from Movie m where m.id =:id",Movie.class);
            query.setParameter("id", id);
            return query.getSingleResult();
        }finally{
            em.close();
        }
    }
    
    public List<Movie> findByTitle(String title){
        EntityManager em = emf.createEntityManager();
            try {
                TypedQuery<Movie> query
            }
    }
    
    
    
    
    
//
//    private static MovieFacade instance;
//    private static EntityManagerFactory emf;
//    
//    //Private Constructor to ensure Singleton
//    private MovieFacade() {}
//    
//    
//    /**
//     * 
//     * @param _emf
//     * @return an instance of this facade class.
//     */
//    public static MovieFacade getFacadeExample(EntityManagerFactory _emf) {
//        if (instance == null) {
//            emf = _emf;
//            instance = new MovieFacade();
//        }
//        return instance;
//    }
//
//    private EntityManager getEntityManager() {
//        return emf.createEntityManager();
//    }
//    
//    //TODO Remove/Change this before use
//    public long getRenameMeCount(){
//        EntityManager em = emf.createEntityManager();
//        try{
//            long renameMeCount = (long)em.createQuery("SELECT COUNT(r) FROM RenameMe r").getSingleResult();
//            return renameMeCount;
//        }finally{  
//            em.close();
//        }
//        
//    }

}
