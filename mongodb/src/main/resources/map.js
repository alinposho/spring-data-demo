function() {
	for(i in this.accounts) {
		emit(this.firstName, this.accounts[i].balance);
	}
}