package vendingmachine.backend.services;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionHistoryService {
  private List<String> history = new ArrayList<>();

  public void addHistory() {
    history.add("Soda sold at " + LocalDateTime.now());
  }

  public List<String> getHistory() {
    return history;
  }
}
