package be.pj.threads.workflow.document;

import be.pj.threads.common.DocumentQueue;
import be.pj.threads.workflow.document.tasks.*;

import java.io.File;
import java.util.HashMap;
import java.util.Map;


public class SampleWorkflow {

    public static void main(String[] args) {
        DocumentQueue preCheckQueue = new DocumentQueue(DocStatus.CHECK);
        DocumentQueue preDispatchQueue = new DocumentQueue(DocStatus.DISPATCH);
        DocumentQueue preTrashQueue = new DocumentQueue(DocStatus.TRASH);
        DocumentQueue preBillQueue = new DocumentQueue(DocStatus.BILL);
        DocumentQueue preSendQueue = new DocumentQueue(DocStatus.SEND);
        DocumentQueue preOrderQueue = new DocumentQueue(DocStatus.ORDER);
        DocumentQueue preBackupQueue = new DocumentQueue(DocStatus.BACKUP);

        Map<DocStatus, DocumentQueue> postCheck = new HashMap<>();
        postCheck.put(DocStatus.DISPATCH, preDispatchQueue);
        postCheck.put(DocStatus.TRASH, preTrashQueue);


        Map<DocStatus, DocumentQueue> postDispatch = new HashMap<>();
        postDispatch.put(DocStatus.BILL, preBillQueue);
        postDispatch.put(DocStatus.SEND, preSendQueue);
        postDispatch.put(DocStatus.ORDER, preOrderQueue);


        Map<DocStatus, DocumentQueue> postBill = new HashMap<>();
        postBill.put(DocStatus.BACKUP, preBackupQueue);
        postBill.put(DocStatus.SEND, preSendQueue);

        Map<DocStatus, DocumentQueue> postSend = new HashMap<>();
        postSend.put(DocStatus.BACKUP, preBackupQueue);

        Map<DocStatus, DocumentQueue> postOrder = new HashMap<>();
        postOrder.put(DocStatus.BILL, preBillQueue);
        postOrder.put(DocStatus.SEND, preSendQueue);


        File backupFile = new File("backup.txt");
        if (backupFile.exists()) {
            backupFile.delete();
        }

        DocumentGenerator docGen = new DocumentGenerator(preCheckQueue);
        TaskCheck check = new TaskCheck(preCheckQueue, postCheck);
        TaskDispatch dispatch = new TaskDispatch(preDispatchQueue, postDispatch);
        TaskTrash trash = new TaskTrash(preTrashQueue, null);
        TaskBill bill = new TaskBill(preBillQueue, postBill);
        TaskSend send = new TaskSend(preSendQueue, postSend);
        TaskOrder order = new TaskOrder(preOrderQueue, postOrder);
        TaskBackup backup = new TaskBackup(preBackupQueue, null, backupFile);


        new Thread(docGen).start();
        new Thread(check).start();
        new Thread(dispatch).start();
        new Thread(trash).start();
        new Thread(bill).start();
        new Thread(send).start();
        new Thread(order).start();
        new Thread(backup).start();

    }
}
