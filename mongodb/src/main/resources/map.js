function() {
	for(i in this.accounts) {
		emit(this._id, this.accounts[i].balance);
	}
}