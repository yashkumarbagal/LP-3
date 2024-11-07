// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

contract Bank {
    mapping(address => uint256) private balances;

    // Deposit function
    function depositMoney(uint256 amount) public {
        require(amount > 0, "Amount must be greater than 0");
        balances[msg.sender] += amount;
    }

    // Withdraw function
    function withdrawMoney(uint256 amount) public {
        require(amount <= balances[msg.sender], "Insufficient Balance");
        balances[msg.sender] -= amount;
        // payable(msg.sender).transfer(amount); // Uncomment if using actual Ether transfer
    }

    // Show balance function
    function showBalance() public view returns (uint256) {
        return balances[msg.sender];
    }
}
