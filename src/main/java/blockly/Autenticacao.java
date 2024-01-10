package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.Iterator;
import java.util.concurrent.Callable;


@CronapiMetaData(type = "blockly")
@CronappSecurity
public class Autenticacao {

public static final int TIMEOUT = 300;

/**
 *
 * @param username
 * @param password
 *
 * @author Igor Andrade
 * @since 10/01/2024, 18:57:51
 *
 */
public static Var ParaAutenticar(@ParamMetaData(description = "username", id = "cdbc02a6") Var username, @ParamMetaData(description = "password", id = "5f32a481") Var password) throws Exception {
 return new Callable<Var>() {

   private Var usuarios = Var.VAR_NULL;
   private Var valorBooleano = Var.VAR_NULL;
   private Var i = Var.VAR_NULL;
   private Var obterUsuario = Var.VAR_NULL;
   private Var obterSenha = Var.VAR_NULL;

   public Var call() throws Exception {
    usuarios =
    cronapi.json.Operations.toJson(
    Var.valueOf("[{\"username\":\"user1\",\"password\":\"senha1\",\"email\":\"user1@email.com\"},{\"username\":\"user2\",\"password\":\"senha2\",\"email\":\"user2@email.com\"}]"));
    valorBooleano =
    Var.VAR_NULL;
    if (
    cronapi.logic.Operations.isNullOrEmpty(password)
    .negate().getObjectAsBoolean()) {
        valorBooleano =
        Var.VAR_FALSE;
        for (Iterator it_i = usuarios.iterator(); it_i.hasNext();) {
            i = Var.valueOf(it_i.next());
            obterUsuario =
            cronapi.json.Operations.getJsonOrMapField(i,
            Var.valueOf("username"));
            obterSenha =
            cronapi.json.Operations.getJsonOrMapField(i,
            Var.valueOf("password"));
            if (
            Var.valueOf(
            Var.valueOf(obterUsuario.equals(username)).getObjectAsBoolean() &&
            Var.valueOf(obterSenha.equals(password)).getObjectAsBoolean()).getObjectAsBoolean()) {
                valorBooleano =
                Var.VAR_TRUE;
                break;
            }
        } // end for
    } else if (
    cronapi.logic.Operations.isNullOrEmpty(username)
    .negate().getObjectAsBoolean()) {
        valorBooleano =
        Var.VAR_FALSE;
        for (Iterator it_i = usuarios.iterator(); it_i.hasNext();) {
            i = Var.valueOf(it_i.next());
            obterUsuario =
            cronapi.json.Operations.getJsonOrMapField(i,
            Var.valueOf("username"));
            if (
            Var.valueOf(obterUsuario.equals(username)).getObjectAsBoolean()) {
                valorBooleano =
                Var.VAR_TRUE;
                break;
            }
        } // end for
    } else {
        valorBooleano =
        Var.VAR_FALSE;
    }
    return valorBooleano;
   }
 }.call();
}

/**
 *
 * @param username
 *
 * @author Igor Andrade
 * @since 10/01/2024, 18:57:51
 *
 */
public static Var ParaObterGruposAcesso(@ParamMetaData(description = "username", id = "f78e3a92") Var username) throws Exception {
 return new Callable<Var>() {

   private Var listaGrupos = Var.VAR_NULL;

   public Var call() throws Exception {
    /**
     * Essa função deve ser associada à ação "Para Obter Grupos de Acesso"
     * da funcionalidade Eventos e Ações. Ainda nas configurações da ação,
     * selecione a constante "username" no parâmetro "username" da função.
     *
     * Ao logar com os 2 usuários da função ParaAutenticar, apenas o usuário
     * "user1" estará vinculado com o grupo "Administrators".
     */
    listaGrupos =
    Var.VAR_NULL;
    if (
    cronapi.logic.Operations.isNullOrEmpty(username)
    .negate().getObjectAsBoolean()) {
        if (
        Var.valueOf(username.equals(
        Var.valueOf("user1"))).getObjectAsBoolean()) {
            listaGrupos =
            cronapi.list.Operations.newList(
            Var.valueOf("Administrators"));
        }
    }
    return listaGrupos;
   }
 }.call();
}

}

