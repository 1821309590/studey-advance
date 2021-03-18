package advance.datastructure.tree;

import org.junit.jupiter.api.Test;
import studey.advance.datastructure.enums.PermissionLevelEnum;
import studey.advance.datastructure.pojo.PermissionResource;
import studey.advance.datastructure.tree.MultNode;
import studey.advance.datastructure.utils.JsonUtil;
import studey.advance.questiontypes.tree.MultTreeCompleteSolution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MultCompleteSolutionTest extends MultTreeCompleteSolution {

    @Test
    void viewCompleteSoloTree() {


        List<MultNode.PermissionNode> permissionNodes = new ArrayList<>();
        MultNode.PermissionNode aWwwOperation = new MultNode.PermissionNode(Collections.singletonList(-1),1, PermissionLevelEnum.PERMISSION_MENU.getCode(),-1,Boolean.TRUE,
            new PermissionResource("A网站运营菜单","/aWebsiteOperation","A网站运营帮助...","a-website-operation","svg"));
        permissionNodes.add(new MultNode.PermissionNode(Collections.unmodifiableList(Arrays.asList(-1,1)),2, PermissionLevelEnum.PERMISSION_MENU.getCode(),1,Boolean.TRUE,
            new PermissionResource("A统计菜单","/statistics","统计帮助...","statistics","svg")));

        permissionNodes.add(new MultNode.PermissionNode(Collections.unmodifiableList(Arrays.asList(-1,1,2)),3, PermissionLevelEnum.FINE_GRIT_PERMISSION.getCode(),2,Boolean.FALSE,
            new PermissionResource("A转换率统计权限","/conversionRate","转换率帮助...","conversion-rate","png")));
        permissionNodes.add(new MultNode.PermissionNode(Collections.unmodifiableList(Arrays.asList(-1,1,2)),4, PermissionLevelEnum.FINE_GRIT_PERMISSION.getCode(),2, Boolean.FALSE,
            new PermissionResource("A曝光率统计权限","/exposureRate","曝光率帮助...","exposure-rate","png")));

        MultNode.PermissionNode moneyGeneralLedger = new MultNode.PermissionNode(Collections.singletonList(-1),5, PermissionLevelEnum.PERMISSION_MENU.getCode(),-1,Boolean.TRUE,
            new PermissionResource("资金总账管理菜单","/fundsManagement","资金总账帮助...","funds-management","svg"));

        permissionNodes.add(moneyGeneralLedger);
        permissionNodes.add(new MultNode.PermissionNode(Collections.unmodifiableList(Arrays.asList(-1,5)),6, PermissionLevelEnum.FINE_GRIT_PERMISSION.getCode(),5,Boolean.FALSE,
            new PermissionResource("银行对账权限","/bankReconciliation","银行对账帮助...","bank-reconciliation","svg")));

        List<MultNode.RoleNode> roleNodes = new ArrayList<>();
        MultNode.RoleNode directorNetworkOperations = new MultNode.RoleNode(1,"全网运营总监", Collections.singletonList(-1),Boolean.TRUE, null);
        roleNodes.add(directorNetworkOperations);
        roleNodes.add(new MultNode.RoleNode(2,"A网运营总监", Collections.singletonList(1),Boolean.TRUE, aWwwOperation));
        MultNode.RoleNode chiefAccountantGeneraLedger = new MultNode.RoleNode(3,"总账首席会计师", Collections.singletonList(-1),Boolean.TRUE, moneyGeneralLedger);
        roleNodes.add(chiefAccountantGeneraLedger);

        List<MultNode> multNodes = new ArrayList<>();
        multNodes.add(new MultNode(1,"运营老李",Collections.singletonList(directorNetworkOperations)));
        multNodes.add(new MultNode(1,"会计老张",Collections.singletonList(chiefAccountantGeneraLedger)));

        List<MultNode> multTree = this.viewCompleteMultTree(multNodes,roleNodes,permissionNodes);
        System.out.println(JsonUtil.toJsonPretty(multTree));
    }
}
